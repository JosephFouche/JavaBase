/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mecanicoconductor;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Conductor extends Empleado implements Trabajador {
    private String categoria;
    public static final String[] CATEGORIAS ={"PARTICULAR","PROFESIONAL B","PROFESIONAL A","INTERNACIONAL"};

    public Conductor() {
    }

    public Conductor(int sueldo, float horasExtras, int ci, String nombre, byte edad) {
        super(sueldo, horasExtras, ci, nombre, edad);
    }

    public Conductor(String categoria, int sueldo, float horasExtras, int ci, String nombre, byte edad) {
        super(sueldo, horasExtras, ci, nombre, edad);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString()+"Conductor{" + "categoria=" + categoria + '}';
    }
    
    @Override
    public Date marcarEntrada() {
        return new Date(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Date marcarSalida() {
        return new Date(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajando..."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /*Si el Conductor es de categoría Profesional B recibe un plus de 10% del sueldo. En caso
de ser Profesional A, 20%, y si la categoría es Internacional, 30%.*/
    public int calcularSalario(){
    
        int sueldoTotal = getSueldo(); // Obtener el sueldo base del empleado
    
    // Verificar la categoría del conductor y aplicar el porcentaje correspondiente
    for (String cat : CATEGORIAS) {
        if (categoria.equals(cat)) {
            switch (cat) {
                case "PROFESIONAL B":
                    sueldoTotal += sueldoTotal * 0.10; // Agregar un 10% al sueldo base
                    break;
                case "PROFESIONAL A":
                    sueldoTotal += sueldoTotal * 0.20; // Agregar un 20% al sueldo base
                    break;
                case "INTERNACIONAL":
                    sueldoTotal += sueldoTotal * 0.30; // Agregar un 30% al sueldo base
                    break;
                default:
                    // Para las categorías restantes, no se aplica ningún aumento
                    break;
            }
            break; // Terminar el bucle una vez que se ha encontrado la categoría
        }
    }
    
    return sueldoTotal;
    }
    
}
