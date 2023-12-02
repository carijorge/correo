/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2do.state;
import com.mycompany.parcial2do.state.contra1;
/**
 *
 * @author jorgito
 */
public class cajero {
    private State state;
    private String mensaje;
    private String imagen;

    public cajero() {
        this.state = new contra1(this);
        setImagen("src/main/java/cajero/cajero2.png");
    }

    public void changeState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return state;
    }
    
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    public void contras(){
        this.state.contra();
    }
    
}
