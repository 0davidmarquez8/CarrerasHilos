/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Corredor extends Thread {

    private int distancia;
    private int recorrido;
    private String figura;
    public static final String ANSI_RESET = "\u001B[0m";
    private String color;
    private String nombre;

    public Corredor(String color, String figura, String nombre) {
        this.distancia = 30;
        this.color = color;
        this.figura = figura;
        this.nombre = nombre;
        this.recorrido = 0;
    }

    @Override
    public void run() {
        correr();
    }

    public void correr() {
        String contadorRecorre = "";
        String contadorFaltaRecorrer = "";
        boolean bandera = false;
        //if (this.recorrido < this.distancia) {
        for (int i = 0; i < this.distancia; i++) {
            if (this.recorrido != i && bandera == false) {
                //System.out.println(this.color + this.figura + ANSI_RESET);
                contadorRecorre = contadorRecorre + "-";
            } else {
                contadorFaltaRecorrer = contadorFaltaRecorrer + "-";
            }
            if (this.recorrido == i) {
                bandera = true;
            }
        }
        System.out.println(this.color + contadorRecorre + this.figura + contadorFaltaRecorrer + ANSI_RESET);
        this.recorrido += (int) Math.floor(Math.random() * 4 + 1);
        if (this.recorrido <= this.distancia) {
            //System.out.println(this.recorrido);
            correr();
        }
    }
}
