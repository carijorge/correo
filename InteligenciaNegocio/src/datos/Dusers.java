/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import utilitario.cadenaDatos;
import conexiones.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.Calendar;

/**
 *
 * @author jorgito
 */
public class Duser {
   ConexionSQL conn;
    int id;
    String name,email,password,estado,rol_id,persona_id;
    
        public static final String[] headers = {"id", "name", "email", "password", "estado",
            "rol_id", "persona_id"};
        
    public void insertar() throws SQLException{
        String sql="INSERT INTO users(id,name,email,password,estado,rol_id,persona_id)"+
                " Values(?,?,?,?,?,?,?)";
        PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setString(4, password);
        ps.setString(5, estado);
        ps.setString(6, rol_id);
        ps.setString(7, persona_id);

        
        if(ps.executeUpdate()==0){
            System.err.println("Class DUsers.java dice: "
            +"Ocurrio un error al insertar usuario insertar()");
            throw new SQLException();
        } 
    }

    public void editar() throws SQLException{
        String sql="UPDATE users SET name=?, email=?, password=?, estado=? "
                + ",rol_id=?, persona_id=? "+
                " WHERE id=?";
        PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, estado);
        ps.setString(5, rol_id);
        ps.setString(6, persona_id);
        ps.setInt(7, id);
        
        if(ps.executeUpdate()==0){
            System.err.println("Class DUsers.java dice: "
            +"Ocurrio un error al editar usuario editar()");
            throw new SQLException();
        } 
    }
    
    public void eliminar() throws SQLException{
        String sql="DELETE FROM users WHERE"+
                " id=?";
        PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
        ps.setInt(0, id);
        
        if(ps.executeUpdate()==0){
            System.err.println("Class DUsers.java dice: "
            +"Ocurrio un error al eliminar usuario eliminar()");
            throw new SQLException();
        } 
    }

    public List<String[]> listar() throws SQLException{
        List<String[]> lista= new ArrayList<>();
        String sql="SELECT * FROM users";
        PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
        ResultSet set= ps.executeQuery();
        while (set.next()) {            
            lista.add(new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name"),
                set.getString("email"),
                set.getString("password"),
                set.getString("estado"),
            });
        }
        return lista;
    }
    
    public String[] ver() throws SQLException{
        String[] usuario=null;
        String sql="SELECT * FROM users WHERE id=?";
        PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet set= ps.executeQuery();

        if(set.next()){
            usuario=new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name"),
                set.getString("email"),
                set.getString("password"),
                set.getString("estado")
            };

        }else{
            System.err.println("Class DUsers.java dice: "
            +"Ocurrio un error al ver usuario ver()");
            throw new SQLException();
        } 
        return usuario;
    }
    
    public String[] verCorreo() throws SQLException{
        String[] usuario=null;
        String sql="SELECT * FROM users WHERE email=?";
        PreparedStatement ps = new ConexionSQL().conectar().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet set= ps.executeQuery();

        if(set.next()){
            usuario=new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name"),
                set.getString("email"),
                set.getString("password"),
                set.getString("estado")
            };

        }else{
            System.err.println("Class DUsers.java dice: "
            +"Ocurrio un error al ver usuario ver()");
            throw new SQLException();
        } 
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPassword(String password) {
       this.password = password;
        
        
            try {
            // Obtener la instancia del algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Calcular el hash MD5 de la cadena de texto
            byte[] hashBytes = md.digest(password.getBytes());
            
            
            // Convertir el hash a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xFF & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Imprimir el hash MD5 en formato hexadecimal
            System.out.println(hexString.toString());
            
            this.password = hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }

    public void setPersona_id(String persona_id) {
        this.persona_id = persona_id;
    }
    
     public void desconectar() {
        if (conn != null) {
            conn.desconectar();
        }
    }
}
