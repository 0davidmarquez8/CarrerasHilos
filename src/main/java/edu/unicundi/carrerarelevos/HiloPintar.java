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

    private Equipo equipo;
    private boolean bandera;

    public void llenarEquipo() {
        this.equipo = new Equipo("lcas", "\u001B[32m");
        Corredor corredor = new Corredor("A", 1, equipo);
        Corredor corredor1 = new Corredor("B", 2, equipo);
        Corredor corredor2 = new Corredor("C", 3, equipo);

        corredor.start();
        corredor1.start();
        corredor2.start();

    }

    public void pinta2() {
        equipo.pintar();
    }

    @Override
    public void run() {
        while (!bandera) {
            try {
                if (equipo.isEstado()) {
                    bandera=true;
                }
                pinta2();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPintar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
