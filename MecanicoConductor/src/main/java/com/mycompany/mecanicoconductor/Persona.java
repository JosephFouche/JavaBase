/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mecanicoconductor;

/**
 *
 * @author Eduardo
 */
public class Persona {
    protected int ci;
    protected String nombre;
    protected byte edad;

    public Persona() {
    }

    public Persona(int ci, String nombre, byte edad) {
        this.ci = ci;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "ci=" + ci + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
