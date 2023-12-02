/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;

/**
 *
 * @author jorgito
 */
public class constantes {
    
     public static String SERVIDOR = "mail.tecnoweb.org.bo";
    public static int PORT_SMPT = 25;
    public static int PORT_POP3 = 110;
    public static int PORT_DB = 5432;
    public static String FIN_LINE ="\r\n";
    public static String QUIT = "QUIT "+FIN_LINE;
    public static String USER_G= "grupo05sa";
    public static String PASSW = "grup005grup005";
    
        //POP3
    public static String USER="USER ";
    public static String PASS = "PASS ";
    public static String STAT= "STAT "+FIN_LINE;
    public static String LIST= "LIST "+FIN_LINE;
    public static String RETR = "RETR ";
    public static String DELE = "DELE ";

    //SMTP
        public static String HELO = "HELO ";
    public static String MAIL_FROM = "MAIL FROM: ";
    public static String RCPT_TO = "RCPT TO: ";
    public static String DATA = "DATA" + FIN_LINE;
    public static String SUBJECT = "SUBJECT: ";
    public static String FINSUBJECT = ".\r\n";
    public static String Subject = "Subject:";

    
    //PSQL
    public static String PSQL = "jdbc:postgresql://";
    //public static String Slash = "/";
    //public static String dosPuntos = ":";
    public static String fileNamePostgres = "org.postgresql.Driver";
    public static String DB_NAME = "db_grupo05sa";
    
}
