/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrera;

/**
 *
 * @author user
 */
public class Main {

     public static void main(String[] args) {
        Corredor corredor = new Corredor("\u001B[31m","C", "Camilo");  
        corredor.start();
        Corredor corredor2 = new Corredor("\u001B[34m","A", "Andres"); 
        corredor2.start();
        Corredor corredor3 = new Corredor("\u001B[33m","J", "Juan");
        corredor3.start();
        
    }
    
}
