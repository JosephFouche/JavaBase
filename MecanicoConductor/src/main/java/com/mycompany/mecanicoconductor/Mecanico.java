
package com.mycompany.mecanicoconductor;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Mecanico extends Empleado implements Trabajador {
    private String especialidad;
    public static final  String[] ESPECIALIDADES={"Motores","Tren Delantero","Inyeccion"};

    public Mecanico() {
    }

    public Mecanico(int sueldo, float horasExtras, int ci, String nombre, byte edad) {
        super(sueldo, horasExtras, ci, nombre, edad);
    }

    public Mecanico(String especialidad, int sueldo, float horasExtras, int ci, String nombre, byte edad) {
        super(sueldo, horasExtras, ci, nombre, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    /*En el caso de un mecánico de motores tiene un plus de 20% sobre el sueldo y el mecánico
de inyección electrónica tiene 30%.*/
    public int calcularSalario(){
           int sueldoTotal = getSueldo(); // Obtener el sueldo base del empleado
    
    // Verificar la categoría del conductor y aplicar el porcentaje correspondiente
    for (String esp : ESPECIALIDADES) {
        if (especialidad.equals(esp)) {
            switch (esp) {
                case "Motores":
                    sueldoTotal += sueldoTotal * 0.20; // Agregar un 20% al sueldo base
                    break;
                case "Inyeccion":
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

    @Override
    public String toString() {
        return super.toString()+"Mecanico{" + "especialidad=" + especialidad + '}';
    }

    @Override
    public Date marcarEntrada() {
        return new Date(); 
    }

    @Override
    public Date marcarSalida() {
       return new Date(); 
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajando..."); 
        
    }
   
}  
    

