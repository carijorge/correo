/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.activation.*;
import javax.mail.internet.*;

import utilitario.correo;
/**
 *
 * @author jorgito
 */
public class envioCorreo implements Runnable {
    private correo email;
    private final static String port_SMTP="465";
    private final static String protocol="smtp";
    private final static String host="mail.tecnoweb.org.bo";
    private final static String user="grupo05sa";
    private final static String mail="grupo05sa@tecnoweb.org.bo";
    private final static String mail_Password="grup005grup005";

    public envioCorreo(correo email) {
        this.email = email;
    }

    @Override
    public void run() {
    Properties properties=new Properties();
        properties.put("mail.transport.protocol", protocol);
        
        
        /***/
    properties.setProperty("mail.smtp.password", mail_Password);
         properties.setProperty("mail.smtp.user", user);
       
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port_SMTP);
        //properties.setProperty("mail.smtp.tls.enable", "true");//usando tecnoWeb
        properties.setProperty("mail.smtp.ssl.enable", "true");//usando Gmail
        properties.setProperty("mail.smtp.auth", "true");
        Session session;
        session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user,mail_Password);
            }
        });
        
        
        
        try{
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            
            InternetAddress[] toAddresses = {new InternetAddress(email.getTo())};
            
            message.setRecipients(MimeMessage.RecipientType.TO, toAddresses);
            message.setSubject(email.getSubject());
            
            Multipart multipart = new MimeMultipart("alternative");
            MimeBodyPart htmlPart= new MimeBodyPart();
            
            htmlPart.setContent(email.getMessage(),"text/html; charset = utf-8");
            multipart.addBodyPart(htmlPart);
            message.setContent(multipart);
            message.saveChanges();
            
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(envioCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    
}
