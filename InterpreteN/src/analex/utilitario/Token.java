/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analex.utilitario;

/**
 *
 * @author jorgito
 */
public class Token {
    private int name;
    private int atribute;

    ///constante numerica para manejar analex
    public static final int cu = 0;
    public static final int action = 1;
    public static final int params = 2;
    public static final int end = 3;
    public static final int error = 4;

//CU valores entre el 100-199
    // id de casos de uso 
   /* public static final int usuario = 100;
    public static final int paciente = 101;
    public static final int persona = 102;
    public static final int contrato = 103;
    public static final int categoria = 104;
    public static final int producto = 105;
    public static final int tipo_servicio = 106;
    public static final int servicio = 107;
    public static final int detalle_servicio = 108;
    public static final int atencion = 109;
    public static final int detalle_atencion = 110;
    public static final int pago = 111;
    public static final int receta = 112;
    public static final int detalle_receta = 113;
    public static final int ayuda = 114;
    public static final int activo = 115;*/
    
    
    
    ///valores de accion del caso de uso 200-299
    public static final int add = 200;
    public static final int delete = 201;
    public static final int modify = 202;
    public static final int get = 203;
    public static final int verify = 204;
    public static final int cancel = 205;
    public static final int report = 206;
    public static final int list = 207;
    public static final int ver = 208;
    public static final int help = 209;

    //identificadores de errores
    public static final int error_Command = 300;
    public static final int error_Character = 301;

    
    //constante linteral
    public static final String lexeme_CU = "caso de uso";
    public static final String lexeme_Action = "action";
    public static final String lexeme_Params = "params";
    public static final String lexeme_End = "end";
    public static final String lexeme_Error = "error";

    
    
    
        /**
     *
     */

   /* public static final String lexeme_User = "user";
    public static final String lexeme_Persona = "persona";
    public static final String lexeme_Paciente = "paciente";
    public static final String lexeme_activo = "activo";
    public static final String lexeme_contrato = "contrato" ;
    public static final String lexeme_categoria = "categoria" ;
    public static final String lexeme_producto = "producto" ;
    public static final String lexeme_tipo_servicio = "tipoServicio" ;
    public static final String lexeme_servicio = "servicio" ;
    public static final String lexeme_detalle_servicio = "detalleServicio" ;
    public static final String lexeme_atencion = "atencion" ;
    public static final String lexeme_detalle_atencion = "detalleAtencion" ;
    public static final String lexeme_pago = "pago" ;
    public static final String lexeme_receta = "receta" ;
    public static final String lexeme_detalle_receta = "detalleReceta" ;
    public static final String lexeme_ayuda = "ayuda" ;*/

    
    
    
    
    public static final String lexeme_Add = "add";
    public static final String lexeme_Delete = "delete";
    public static final String lexeme_Modify = "modify";
    public static final String lexeme_Get = "get";
    public static final String lexeme_Verify = "verify";
    public static final String lexeme_Cancel = "cancel";
    public static final String lexeme_Report = "report";
    public static final String lexeme_list = "list";
    public static final String lexeme_ver = "ver";
    public static final String lexeme_help = "help";

    public static final String lexeme_Error_Command = "UNKNOWN COMMAND";
    public static final String lexeme_Error_Character = "UNKNOWN CHARACTER";
}
