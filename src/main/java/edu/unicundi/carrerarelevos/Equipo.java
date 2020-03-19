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
    private int data;
    public static final String ANSI_RESET = "\u001B[0m";
    private int recorrido;

    public Equipo(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        
        for (int i = 0; i < 90; i++) {
            this.distancia[i]="-";
        }
    }
    public void pintar(){
        for (int i = 0; i < this.distancia.length; i++) {
            System.out.print(this.color+this.distancia[i]+ANSI_RESET);
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
