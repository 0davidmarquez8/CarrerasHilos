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
public class Corredor extends Thread {

    private String figura;
    private int posicion;
    private Equipo equipo;
    private int auxiliar;
    private int recorrido;
    private int recorrido2;
    private int contador;

    public Corredor(String figura, int posicion, Equipo equipo) {
        this.figura = figura;
        this.posicion = posicion;
        this.equipo = equipo;
        this.recorrido2 = 30;
        this.contador = 0;

        for (int i = 0; i < this.equipo.getDistancia().length; i++) {
            if (i == 0 && this.posicion == 1) {
                this.equipo.getDistancia()[i] = this.figura;
            } else if (i == 30 && this.posicion == 2) {
                this.equipo.getDistancia()[i] = this.figura;
            } else if (i == 60 && this.posicion == 3) {
                this.equipo.getDistancia()[i] = this.figura;
            }
        }

    }

    @Override

    public void run() {
        correr();

    }

    public void correr() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.posicion == 1) {
            this.equipo.getDistancia()[this.auxiliar] = "-";
            this.equipo.getDistancia()[this.recorrido] = this.figura;
            if (this.recorrido != 30) {

                if (this.recorrido < 30) {
                    this.auxiliar = this.recorrido;
                    this.recorrido += (int) Math.floor(Math.random() * 4 + 1);
                    if (this.recorrido > 30) {
                        this.auxiliar = this.recorrido;
                        this.recorrido = 30;
                    }
                }
                correr();
            } 
//            else {
////                this.equipo.getDistancia()[this.auxiliar] = "-";
////                this.equipo.getDistancia()[this.recorrido] = this.figura;
//                equipo.setEstado(true);
//            }
            synchronized (equipo) {
                equipo.notifyAll();
            }
        } else if (this.posicion == 2) {
            equipo.setEstado(false);
            this.equipo.getDistancia()[this.auxiliar] = "-";
            this.equipo.getDistancia()[30]="A";
            this.equipo.getDistancia()[this.recorrido2] = this.figura;
            if (contador == 0) {

                synchronized (equipo) {
                    try {
                        equipo.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (this.recorrido2 != 60) {
                    if (this.recorrido2 < 60) {

                        this.auxiliar = this.recorrido2;
                        this.recorrido2 += (int) Math.floor(Math.random() * 4 + 1);
                        if (this.recorrido2 > 60) {
                            this.auxiliar = this.recorrido2;
                            this.recorrido2 = 60;
                        }
                    }
                    contador = 1;
                    correr();
                } else {
                    equipo.setEstado(true);
                }
            } else {

                if (this.recorrido2 != 60) {
                    if (this.recorrido2 < 60) {

                        this.auxiliar = this.recorrido2;
                        this.recorrido2 += (int) Math.floor(Math.random() * 4 + 1);

                        if (this.recorrido2 > 60) {
                            this.auxiliar = this.recorrido2;
                            this.recorrido2 = 60;
                        }
                    }
                    contador = 1;
                    correr();
                } else {
                    equipo.setEstado(true);
                }
            }

        }

    }
}
