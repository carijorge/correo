/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package analex.interfaces;

import evento.eventoToken;
/**
 *
 * @author jorgito
 */
public interface ListaEventoToken {
    
    void user(eventoToken evento);
    void persona(eventoToken evento);
    void categoria(eventoToken evento);
    void producto(eventoToken evento);
    void venta(eventoToken evento);
    void bitacora(eventoToken evento);
    void carrito(eventoToken evento);
    void carritoDetalle(eventoToken evento);
    void inventario(eventoToken evento);
    void reportestadistica(eventoToken evento);
    void error(eventoToken eventoo);
    void ayuda(eventoToken evento);
    void activo(eventoToken evento);
}
