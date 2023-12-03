/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.Duser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorgito
 */
public class NUsers {
    private Duser dato;

    public NUsers() {
        dato = new Duser();
    }
    
   
    public void insertar(List<String> parametros, String email) {
        try {
            dato.setId(Integer.parseInt(parametros.get(0)));
            dato.setName(parametros.get(1));
            dato.setEmail(parametros.get(2));
            dato.setPassword(parametros.get(3));
            dato.setEstado(parametros.get(4));
            dato.setPersona_id(parametros.get(5));
            dato.setRol_id(parametros.get(6));

            dato.insertar();
            dato.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void editar(List<String> parametros, String email) {
        try {
            dato.setId(Integer.parseInt(parametros.get(0)));
            dato.setName(parametros.get(1));
            dato.setEmail(parametros.get(2));
            dato.setPassword(parametros.get(3));
            dato.setEstado(parametros.get(4));
            dato.setPersona_id(parametros.get(5));
            dato.setRol_id(parametros.get(6));

            dato.editar();
            dato.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    
    public void eliminar(List<String> parametros, String email) {
        try {
            dato.setId(Integer.parseInt(parametros.get(0)));

            dato.eliminar();
            dato.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public List<String[]> listar(String email) {
        List<String[]> lista = new ArrayList<>();
        try {
            lista = dato.listar();
            dato.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public int getIdByEmail(String email) {
        int id = -1;
        try {
            id = dato.getIdByEmail(email);
            dato.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    public String hashPassword(String password) {
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

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     
    public String[] ver(List<String> parametros, String email) {
        String[] d = null;
        try {
            dato.setId(Integer.valueOf(parametros.get(0)));
            
            d = dato.ver();
            dato.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(NPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
 
    public String[]  headers() {
        return dato.headers;
    }
    
}
