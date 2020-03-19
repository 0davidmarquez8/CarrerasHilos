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
    private int recorrido3;

    private static boolean bandera;
    private static boolean bandera2;

    public Corredor(String figura, int posicion, Equipo equipo) {
        this.figura = figura;
        this.posicion = posicion;
        this.equipo = equipo;
        this.recorrido2 = 30 + (int) Math.floor(Math.random() * 4 + 1);
        this.recorrido3 = 60 + (int) Math.floor(Math.random() * 4 + 1);
        this.bandera = false;
        this.bandera2 = false;

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
        // validacion de  hilo 
        if (this.posicion == 1) {
            avanzarPosicionUno();

        } else if (this.posicion == 2) {
            if (bandera == false) {

                synchronized (equipo) {
                    try {
                        equipo.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                avanzarPosicionDos();
            } else {
                avanzarPosicionDos();
            }
        } else {
            if (bandera2 == false) {
                if (!bandera) {
                    synchronized (equipo) {
                        try {
                            equipo.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    synchronized (equipo) {
                        try {
                            equipo.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    avanzarPosicionTres();
                }
            } else {
                avanzarPosicionTres();
            }
        }

    }

    public void avanzarPosicionUno() {
        this.equipo.getDistancia()[this.auxiliar] = "-";
        this.equipo.getDistancia()[this.recorrido] = this.figura;
        if (this.recorrido != 30) {

            if (this.recorrido < 30) {
                this.auxiliar = this.recorrido;
                this.recorrido += (int) Math.floor(Math.random() * 4 + 1);
                if (this.recorrido > 30) {
                    this.recorrido = 30;

                }
            }
            correr();
        } else {
            bandera = true;
            synchronized (equipo) {
                equipo.notifyAll();
            }
            this.equipo.getDistancia()[30] = this.figura;
        }
    }

    public void avanzarPosicionDos() {

        if (this.recorrido2 != 60) {
            this.equipo.getDistancia()[this.auxiliar] = "-";
            this.equipo.getDistancia()[this.recorrido2] = this.figura;
            if (this.recorrido2 < 60) {
                this.auxiliar = this.recorrido2;
                this.recorrido2 += (int) Math.floor(Math.random() * 4 + 1);
                if (this.recorrido2 > 60) {
                    this.recorrido2 = 60;

                }
            }
            correr();
        } else {
            bandera2 = true;
            synchronized (equipo) {
                equipo.notifyAll();
            }
            this.equipo.getDistancia()[60] = this.figura;
            this.equipo.getDistancia()[this.auxiliar] = "-";
        }

    }

    public void avanzarPosicionTres() {

        if (this.recorrido3 != 89) {
            this.equipo.getDistancia()[this.auxiliar] = "-";
            this.equipo.getDistancia()[this.recorrido3] = this.figura;
            if (this.recorrido3 < 89) {
                this.auxiliar = this.recorrido3;
                this.recorrido3 += (int) Math.floor(Math.random() * 4 + 1);
                if (this.recorrido3 > 89) {
                    this.recorrido3 = 89;

                }
            }
            correr();
        } else {
            this.equipo.getDistancia()[89] = this.figura;
            equipo.setEstado(true);
            HiloPintar hiloPintar = new HiloPintar();
            hiloPintar.setBandera(true);
            System.out.println("Ganador: " + equipo.getNombre());
//            System.exit(0);
        }
    }

}
