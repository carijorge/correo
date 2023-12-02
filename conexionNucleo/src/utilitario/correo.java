/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitario;

/**
 *
 * @author jorgito
 */
public class correo {
    public static final String SUBJECT = "Request respose";
    private String from;
    private String to;
    private String subject;
    private String message;
    
public correo(String from, String to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public correo(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public correo(String from, String subject) {
        this.from = from;
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tFrom: " + from + ",\n" +
                "\tTo: " + to + ",\n" +
                "\tSubject: " + subject + ",\n" +
                "\tMessage: " + message + "\n" +
                "}\n";
    }
    
    
}
