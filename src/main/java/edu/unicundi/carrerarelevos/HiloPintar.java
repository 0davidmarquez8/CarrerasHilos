/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROFESIONAL
 */
public class HiloPintar extends Thread {

    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private static String ganador;

    private boolean bandera;

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

    public void pinta2() {
        equipo1.pintar();
        equipo2.pintar();
        equipo3.pintar();
    }

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

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

}
