/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerarelevos;

/**
 *
 * @author Juan Camilo 
 * Metodo principal
 */
public class Main {
    
    public static void main(String[] args) {
        boolean bandera = false;
        HiloPintar hiloPintar = new HiloPintar();
        hiloPintar.llenarEquipo();
        hiloPintar.start();        

    }
}
