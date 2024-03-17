/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mecanicoconductor;

/**
 *
 * @author Eduardo
 */
public abstract class Empleado extends Persona {
    private int sueldo;
    private float horasExtras;
    public static final int SUELDO_MINIMO = 1824000;

    public Empleado() {
    }

    public Empleado(int sueldo, float horasExtras, int ci, String nombre, byte edad) {
        super(ci, nombre, edad);
        this.sueldo = sueldo;
        this.horasExtras = horasExtras;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(float horasExtras) {
        float horaDiaria = (sueldo/30)/8;
        horasExtras =  (float) (horaDiaria*1.5);
        this.horasExtras = horasExtras;
    }
    

    @Override
    public String toString() {
        return super.toString()+"Empleado{" + "sueldo=" + sueldo + ", horasExtras=" + horasExtras + '}';
    }
    //El cálculo de las horas extras es de 50% más su sueldo normal por hora
    /*Primero que nada, vamos a averiguar tu salario por hora regular, 
    dividiendo tu salario mensual entre 30 días del mes y 
    public void setSalario(int salario) {
        if(salario < SALARIO_MINIMO) salario = SALARIO_MINIMO;
        this.salario = salario;
    }
    luego entre las 8 horas de jornada diurna:*/
    public int calcularSalario(int sueldo){
       return (int) (sueldo+horasExtras);
    }
    
    
}
