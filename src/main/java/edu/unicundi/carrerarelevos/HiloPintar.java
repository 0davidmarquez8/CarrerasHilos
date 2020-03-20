/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase HiloPintar que hereda de Thread para la revision de los corredores.
 *
 * @author Juan camilo vargas
 */
public class HiloPintar extends Thread {

    /*variable que almacena la instancia del equipo1*/
    private Equipo equipo1;
    /*variable que almacena la instancia del equipo2*/
    private Equipo equipo2;
    /*variable que almacena la instancia del equipo3*/
    private Equipo equipo3;
    private static String ganador;

    /*variable que almacena el estado del programa para finalizarlo*/
    private boolean bandera;

    /**
     * Metodo que inicia parametros de equipo y corredores
     *
     */
    public void llenarEquipo() {
        this.equipo1 = new Equipo("Equipo1", "\u001B[35m");
        this.equipo2 = new Equipo("Equipo2", "\u001B[31m");
        this.equipo3 = new Equipo("Equipo3", "\u001B[33m");

        Corredor corredor = new Corredor("A", 1, equipo1);
        Corredor corredor1 = new Corredor("B", 2, equipo1);
        Corredor corredor2 = new Corredor("C", 3, equipo1);
        Corredor corredor3 = new Corredor("D", 1, equipo2);
        Corredor corredor4 = new Corredor("E", 2, equipo2);
        Corredor corredor5 = new Corredor("F", 3, equipo2);
        Corredor corredor6 = new Corredor("G", 1, equipo3);
        Corredor corredor7 = new Corredor("H", 2, equipo3);
        Corredor corredor8 = new Corredor("J", 3, equipo3);
        corredor.start();
        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();

    }

    /**
     * Metodo que campura el pintado de la carrera
     *
     */
    public void pinta2() {
        equipo1.pintar();
    }

    /**
     * Metodo que inicia el hilo llama al metodo
     *
     */
    @Override
    public void run() {
        while (!bandera) {
            try {
                if (equipo1.isEstado()) {
                    this.bandera = true;
                }
                pinta2();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPintar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Equipo ganador: " +this.getGanador());
    }

    /**
     * Metodo retorna el estado del hilo
     *
     */
    public boolean isBandera() {
        return bandera;
    }

     /**
     * Metodo recibe el estado del hilo
     *
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

}
