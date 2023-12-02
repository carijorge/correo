/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analex;

import analex.models.TokenCommand;
import analex.interfaces.ListaEventoToken;
import analex.utilitario.Token;
import evento.eventoToken;
import javax.swing.plaf.basic.BasicListUI;

/**
 *
 * @author jorgito
 */
public class interprete implements Runnable{
    
    private ListaEventoToken listener;
    private analex analex;
    private String command;
    private String sender;

    public interprete(String command, String sender) {
        this.command = command;
        this.sender = sender;
    }

    public ListaEventoToken getListener() {
        return listener;
    }

    public void setListener(ListaEventoToken listener) {
        this.listener = listener;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    
    private void filterEvent( TokenCommand token_command) {
        eventoToken token_event = new eventoToken (this,sender);
        
        token_event.setAction(token_command.getAction());
        
        int count_params = token_command.countParams();
        for (int i=0 ; i<count_params ; i++){
            int pos = token_command.getParams(i);
            token_event.addParams(analex.getParam(pos));
        }
        
        switch (token_command.getName()) {
            case Token.usuario:
                listener.user(token_event);
                break;
            case Token.persona:
                listener.persona(token_event);
                break;
            case Token.categoria:
                listener.categoria(token_event);
                break;
            case Token.producto:
                listener.producto(token_event);
                break;
            case Token.venta:
                listener.venta(token_event);
                break;
            case Token.bitacora:
                listener.bitacora(token_event);
                break;
            case Token.carrito:
                listener.carrito(token_event);
                break;
            case Token.carritoDetalle:
                listener.carritoDetalle(token_event);
                break;
            case Token.inventario:
                listener.inventario(token_event);
                break;
            case Token.reporte:
                listener.reportestadistica(token_event);
                break;
            case Token.ayuda:
                listener.ayuda(token_event);
                break;
        }

    }   
    
    private void tokenError(Token token, String error){
        eventoToken token_event = new eventoToken(this, sender);
        token_event.setAction(token.getAtribute());
        token_event.addParams(command);
        token_event.addParams(error);
        listener.error(token_event);
        
    }
    
    public void run() {
        analex = new analex(command);
        TokenCommand token_command = new TokenCommand();
        Token token;
        
        
        while((token = analex.preAnalisis()).getName() != Token.end && token.getName() != Token.error){
            if(token.getName() == Token.cu){
                token_command.setName(token.getAtribute());// id del CU
            } else if(token.getName() == Token.action){
                token_command.setAction(token.getAtribute());// id de la accion
            } else if(token.getName() == Token.params){
                token_command.addParams(token.getAtribute());// la posicion del parametro en el tsp
            }
            analex.next();
        }
        
        if(token.getName() == Token.end){
            filterEvent(token_command);// se analizo el comando con exito
        } else if(token.getName() == Token.error){
            tokenError(token, analex.lexeme()); // se produjo un error en el analisis
        }
        
    }
}
