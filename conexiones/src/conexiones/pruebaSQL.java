/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgito
 */
public class pruebaSQL {
    
    public static void main(String[] args){
        try{
            ConexionSQL coneccion = new ConexionSQL();
            String sql ="SELECT *FROM users";
            PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Resultado "+rs.next());
        } catch (SQLException ex){
            Logger.getLogger(pruebaSQL.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
