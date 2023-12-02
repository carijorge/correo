/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionnucleo;

import utilitario.correo;
import comunicacion.*;

/**
 *
 * @author jorgito
 */
public class ConexionNucleo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        correo emailObjeto = new correo("jorgecsri@gamil.com","prueba","peticion de prueba");
        SMTP senEmail = new SMTP(emailObjeto);
    }
    
}
