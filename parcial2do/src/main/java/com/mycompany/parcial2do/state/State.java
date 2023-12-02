/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2do.state;

/**
 *
 * @author jorgito
 */
public abstract class State {
    cajero cajero;

    public State(cajero cajero) {
        this.cajero = cajero;
    }
    
    public abstract void contra();
    public abstract void retiro();
    public abstract void recibo();   
}
