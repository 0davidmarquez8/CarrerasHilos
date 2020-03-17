/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerarelevos;

/**
 *
 * @author PROFESIONAL
 */
public class Equipo {

    private String nombre;
    private String color;
    private String distancia[]= new String[90];
    private boolean estado;
    public static final String ANSI_RESET = "\u001B[0m";

    public Equipo(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        
        for (int i = 0; i < 90; i++) {
            this.distancia[i]="-";
        }
    }
    public void pintar(){
        for (int i = 0; i < this.distancia.length; i++) {
            System.out.print("\u001B[32m"+this.distancia[i]+ANSI_RESET);
        }
        System.out.println("");
    }

    public String[] getDistancia() {
        return distancia;
    }

    public void setDistancia(String[] distancia) {
        this.distancia = distancia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
