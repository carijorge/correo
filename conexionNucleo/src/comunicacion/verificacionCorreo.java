/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;
import interfaces.correoEvento;
import java.io.*;
import java.net.*;
import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitario.comando;
import utilitario.correo;
import utilitario.extractor;
/**
 *
 * @author jorgito
 */
public class verificacionCorreo implements Runnable{

    private final static  int PORT_POP= 110;
    private final static  String HOST= "mail.tecnoweb.org.bo";
    private final static  String usuario= "grupo05sa";
    private final static  String contr= "grup005grup005";
    
    private Socket socket;
    private BufferedReader input;
    private DataOutputStream output;
    private correoEvento emailEventListener;
    
    public verificacionCorreo(){
        socket = null;
        input = null;
        output = null;
    }

    public correoEvento getEmailEventListener() {
        return emailEventListener;
    }

    public void setEmailEventListener(correoEvento emailEventListener) {
        this.emailEventListener = emailEventListener;
    }
    
    private void authUser(String email, String password) throws IOException, AuthenticationException {
        if (socket != null && input != null && output != null) {
            input.readLine();
            output.writeBytes(comando.user(email));
            input.readLine();
            output.writeBytes(comando.pass(password));

            String message = input.readLine();
            if (message.contains("-ERR")) {

                throw new AuthenticationException();
            }
        }
    }
    
    private int getEmailCount() throws IOException {
        output.writeBytes(comando.stat());
        String line = input.readLine();
        String[] data = line.split(" ");
        return Integer.parseInt(data[1]);
    }
   private List<correo> getEmails(int count) throws IOException {
        List<correo> emails = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            output.writeBytes(comando.retr(i));
            String text = readMultiline();
            
            emails.add(extractor.getCorreo(text));
        }

        return emails;
    }

    private void deleteEmails(int email) throws IOException {
        for (int i = 1; i <= email; i++) {
            output.writeBytes(comando.dele(i));
        }
    }

    private String readMultiline() throws IOException {
        String lines = "";
        while (true) {

            String line = input.readLine();
            if (line == null) {
                throw new IOException("Server no responde(ocurrio un error al abrir el correo)");
            }
            if (line.equals(".")) {
                break;
            }
            lines = lines + "\n" + line;
        }
        return lines;
    }

    @Override
    public void run() {
        while (true) {
                   List<correo> emails = null;
                   try {
                       socket= new Socket(HOST,PORT_POP);
                       input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                       output = new DataOutputStream(socket.getOutputStream());

                       authUser(usuario, contr);

                       System.out.println("*******************conexion establecida**********************");

                       // output.writeBytes(Command.stat());
                       //int count = getEmailCount(input.readLine());
                       int count = getEmailCount();
                       if (count>0) {
                           emails=getEmails(count);
                           System.out.println(emails);

                           deleteEmails(count);
                       }

                       output.writeBytes(comando.quit());
                       input.readLine();
                       input.close();  
                       output.close();
                       socket.close();



                       System.out.println("*******************conexion CERRADA**********************");

                       if (count>0) {
                           emailEventListener.onRecieveEmailEvent(emails);
                       }

                       Thread.sleep(5000);

                   } catch (IOException ex) {
                       Logger.getLogger(verificacionCorreo.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(verificacionCorreo.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (AuthenticationException ex) {
                       Logger.getLogger(verificacionCorreo.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }

           }
}
