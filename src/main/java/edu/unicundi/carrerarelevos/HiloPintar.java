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

    private boolean bandera;

    public void llenarEquipo() {
        this.equipo1 = new Equipo("lcas", "\u001B[35m");
        this.equipo2 = new Equipo("Hola", "\u001B[31m");
        this.equipo3 = new Equipo("Jaja", "\u001B[33m");

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
                    setBandera(true);
                }
                pinta2();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPintar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
}
