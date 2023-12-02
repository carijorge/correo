/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;
import utilitario.correo;
import java.io.*;
import java.net.*;
/**
 *
 * @author jorgito
 */
public class SMTP {
        String servidor = "mail.tecnoweb.org.bo";
        //String servidor="172.20.172.254";
        String user_emisor = "grupo05sa@tecnoweb.org.bo";
        String line;
        String comando = "";
        int puerto = 25;
    public SMTP(correo email) {
       setMensaje(email.getFrom(),email.getSubject(), email.getMessage());
    }    
    
    public void setMensaje(String email,String subject, String data){
            try {
                //se establece conexion abriendo un socket especificando el servidor y puerto SMTP
                Socket socket = new Socket(servidor, puerto);

                BufferedReader entrada;
                DataOutputStream salida;
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                salida = new DataOutputStream(socket.getOutputStream());

                // Escribimos datos en el canal de salida establecido con el puerto del protocolo SMTP del servidor
                if (socket != null && entrada != null && salida != null) {

                    System.out.println("Conectado a " + servidor + " Puerto " + puerto + " succesfull!!..");
                    System.out.println("Escuchando ...........");
                    System.out.println("S: " + entrada.readLine());

                    //saludo al servidor
                    comando = "HELO " + servidor + "\r\n";
                    System.out.print("C : " + comando);
                    salida.writeBytes(comando);
                    System.out.println("S : " + entrada.readLine());
                    //System.out.println("S : "+getMultiline(entrada));


                    //validar coreo emisor 
                    comando = "MAIL FROM : " + user_emisor + "\r\n";
                    System.out.print("C : " + comando);
                    salida.writeBytes(comando);
                    System.out.println("S : " + entrada.readLine());


                    comando = "RCPT TO : " + email + "\r\n";
                    System.out.print("C : " + comando);
                    salida.writeBytes(comando);
                    System.out.println("S : " + entrada.readLine());


                    
                    comando = "DATA\n";
                    System.out.print("C : " + comando);
                    salida.writeBytes(comando);
                    System.out.println("S : " + getMultiline(entrada));

                    comando = "Subject:"+subject+"\r\n" + data + ".\r\n"+ ".\r\n";
                    System.out.print("C : " + comando);
                    salida.writeBytes(comando);
                    System.out.println("S : " + entrada.readLine());

                    comando = "QUIT\r\n";
                    System.out.print("C : " + comando);
                    salida.writeBytes(comando);
                    System.out.println("S : " + entrada.readLine());
                }
                // Cerramos los flujos de salida y de entrada y el socket cliente
                salida.close();
                entrada.close();
                socket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
                System.out.println(" S : No se pudo conectar con el servidor indicado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        static protected String getMultiline(BufferedReader in) throws IOException {
        String lines = "";
        while (true) {
            String line = in.readLine();
            if (line == null) {
                // Server closed connection
                throw new IOException(" S : Server unawares closed the connection.");
            }
            if (line.charAt(3) == ' ') {
                lines = lines + "\n" + line;
                // No more lines in the server response
                break;
            }
            // Add read line to the list of lines
            lines = lines + "\n" + line;
        }
        return lines;
    }
}
