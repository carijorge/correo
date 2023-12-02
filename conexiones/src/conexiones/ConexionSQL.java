/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexiones;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.SwingWorker;
import java.util.*;
/**
 *
 * @author jorgito
 */
public class ConexionSQL {

    private Connection con = null;
    private Statement stmt = null;
    
    private String host;
    private int port;
    private String user;
    private String pass;
    private String dnName;

    public ConexionSQL(String host, int port, String user, String pass, String dnName) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dnName = dnName;
    }
    
    public ConexionSQL(){
        this.host = constantes.SERVIDOR;
        this.port = constantes.PORT_DB;
        this.user = constantes.USER_G;
        this.pass = constantes.PASSW;
        this.dnName=constantes.DB_NAME;
    }
    
    /*public ConexionSQL(){
        this.host = constantes.SERVIDOR;
        this.port = constantes.PORT_DB;
        this.user = "postgres";
        this.pass = "123456789";
        this.dnName = "libreria";
        
    }*/
    
       public Connection conectar(){
        String url = constantes.PSQL + host + ":" + port + "/" + dnName;
        try {
            //Class.forName(ConstGlobal.fileNamePostgres);
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e ) {
            System.err.println(" Class ClientePsql dice: Ocurrio un error al momento de conectar()");
        }
        ejecutarDespuesDe6Segundos();
        return con;
       }
       
       public void desconectar(){
                   try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Class ClientePsql dice: Ocurrio un error al momento de closeConection()");
        }
       }
     public void ejecutarDespuesDe6Segundos() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(9000);
                return null;
            }

            @Override
            protected void done() {
                // Código a ejecutar después de 6 segundos
                desconectar();
            }
        };
        worker.execute();
    }   
    
    public void close() throws SQLException {
        con.close();
    }
    
}
        
