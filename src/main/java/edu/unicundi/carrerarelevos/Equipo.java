/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerarelevos;

/**
 * Clase equipo maneja todos los metodos.
 *
 * @author David Márquez, Juan camilo vargas
 */
public class Equipo {

    /**
     * Variable para guardar el nombre del equipo
     */
    private String nombre;
    /**
     * Variable para guardar el color del equipo
     */
    private String color;
    private String distancia[]= new String[90];
    private static boolean estado;
    
    private int data;
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Constructor que recibe paramtros de equipo
     *
     * @param nombre Almacena el nombre del equipo
     * @param color Almacena el color del equipo
     */
    public Equipo(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;

        for (int i = 0; i < 90; i++) {
            this.distancia[i] = "-";
        }
    }

    /**
     * metodo que imprime los recorridos de los equipos
     */
    public void pintar() {
        for (int i = 0; i < this.distancia.length; i++) {
            System.out.print(this.color + this.distancia[i] + ANSI_RESET);
        }
        System.out.println("");
    }

    /**
     * metodo que retorna la distancia
     */
    public String[] getDistancia() {
        return distancia;
    }

    /**
     * metodo que recibe la distancia
     */
    public void setDistancia(String[] distancia) {
        this.distancia = distancia;
    }

    /**
     * metodo que retorna el
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * metodo que recibe el estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * metodo que retorna el nombre del equipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo que recibe el nombre del equipo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
