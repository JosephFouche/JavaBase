/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mecanicoconductor;
import java.util.Scanner;
/*
 Cree, además, una clase AppPrueba, para probar la clase Conductor y Mecanico, creados
anterioriormente.

Esta clase debe tener el método main, cargar los datos de dos conductores
dentro del programa y permitir cargar los datos de, por lo menos, 1 mecanico por teclado
(utilizar cada uno de los constructores disponibles). Imprimir todos los datos para la verificación
del funcionamiento del programa. El método toString devolverá todas las propiedades de la
clase correspondiente
 * @author Eduardo
 */
public class AppPrueba {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //2 conductores insertar datos por teclado
        Conductor c1 =  new Conductor();
        Conductor c2  = new Conductor();
        
        //Establecer datos de conductor
        c1.setSueldo(1800000);
        c1.setHorasExtras(2);
        c1.setCi(5499630);
        c1.setNombre("Eduardo Martínez");
        c1.setEdad((byte)23);
        c1.setCategoria("INTERNACIONAL");
        c2.setSueldo(1800000);
        c2.setHorasExtras(4);
        c2.setCi(126630);
        c2.setNombre("Blanca Gamarra");
        c2.setEdad((byte)58);
        c2.setCategoria("PROFESIONAL B");
        
        //CALCULAR SALARIO
        int salarioConductor = c1.calcularSalario();
        int salarioConductor2 = c2.calcularSalario();
        // Imprimir todos los datos para la verificación
        System.out.println("Datos del conductor 1:");
        System.out.println(c1.toString());
        
        System.out.println("Datos del conductor 2:");
        System.out.println(c2.toString());
        
        // Cargar datos de al menos un mecánico por teclado
        Mecanico mecanico = cargarDatosMecanico(scanner);
         System.out.println("Datos del mecánico:");
        System.out.println(mecanico.toString());
        
        scanner.close();
    }
    // Método para cargar los datos de un mecánico por teclado
    public static Mecanico cargarDatosMecanico(Scanner scanner) {
        System.out.println("Ingrese la especialidad del mecánico (Motores, Tren Delantero, Inyeccion):");
        String especialidad = scanner.next();
        
        System.out.println("Ingrese el sueldo del mecánico:");
        int sueldo = scanner.nextInt();
        
        System.out.println("Ingrese las horas extras del mecánico:");
        float horasExtras = scanner.nextFloat();
        
        System.out.println("Ingrese el número de CI del mecánico:");
        int ci = scanner.nextInt();
        
        System.out.println("Ingrese el nombre del mecánico:");
        String nombre = scanner.next();
        
         int edad = 0;
    boolean inputValido = false;
    do {
        System.out.println("Ingrese la edad del mecánico:");
        if (scanner.hasNextInt()) {
            edad = scanner.nextInt();
            inputValido = true;
        } else {
            System.out.println("Error: Por favor ingrese un número entero válido.");
            scanner.next(); // Limpiar el buffer del scanner
        }
    } while (!inputValido);

    return new Mecanico(especialidad, sueldo, horasExtras, ci, nombre, (byte) edad);
    }
}
