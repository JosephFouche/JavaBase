/*
 . El Departamento de Informática de la Facultad Politécnica cuenta con cinco salas
de laboratorio, cada una de ellas con 20 computadoras. Se requiere sistematizar
el proceso de reserva o cancelación de turnos para dichas salas en el horario
disponible (12 a 2 pm, únicamente para alumnos), los demás horarios están
reservados para clases. Construya una solución que solicite al usuario la
siguiente información (sala, equipo), tanto para asignar turno como para
cancelarlo. 


Igualmente, el programa deberá permitir conocer el número de
equipos disponibles (sin asignar) por sala, y el número total de turnos asignado
(todas las salas).
Tenga en cuenta que el programa debe de mostrar luego de cada operación el
menú:
- Asignar o cancelar turno
- Cantidad de equipos disponibles por sala
- cantidad de turnos asignados en toda la Facultad
- Salir

Concepto: 
5 [salas], 20 [pcs] = 100 pcs
Construya una solución que solicite al usuario la
siguiente información (sala, equipo) = metodo con parametro (sala, equipo)?
horario de reserva de 12 a 2pm solo para alumnos, pasado el horario es para clases de politecnica
solicitar por teclado sala y equipo? opciones asignar turno/ cancelar turno
Mostar al final cuenta de reservados y equipos diponibles


 */

package com.mycompany.polisalastp1;
import java.util.Scanner;
/**
 *
 * @author Eduardo
 */
public class PoliSalasTP1 {
    
    public int salas = 5;
    public int pcs = 20;
    public int hInicio =12;
    public int hFinal = 14;
    private int reservaT = 0;
    public boolean [][] turnos; //matriz para almacenar la disponibilidad de salas y computadores
    public PoliSalasTP1(int salas, int pcs){//constructor
        this.salas = salas;
        this.pcs = pcs;
        turnos = new boolean[salas][pcs];
    }
    public void mostrarHorario(){
    
        System.out.println("horario disponible: "+hInicio+ " a "+ hFinal+" pm");
    }
   public void reservarTurno(){
   
       Scanner scanner = new Scanner(System.in);//se llama al metodo scanner
       mostrarHorario();//se invoca el método
       System.out.println("Ingresa el numero de la sala: (# -"+salas+ "): ");
       int sala = scanner.nextInt();//se ingresa numero de sala
       
       if(sala<1 || sala>salas){
           
           System.out.println("invalido");
           return;
       }
       System.out.println("Ingresa numero de ordenador (#-"+pcs+" )");
       int ordenador = scanner.nextInt();
       
       
       if(ordenador<1 || ordenador>pcs){
           
           System.out.println("invalido");
       }
       
       if(turnos[sala-1][ordenador-1]){//java cuenta de 0 a n elementos. sala y ordenador empiezan de 1 hasta n. se resta -1 para compatibilizar
       
           System.out.println("La pc ya esta reservada");
       }else{
           turnos[sala-1][ordenador-1]=true;
           System.out.println("Turno asignado correctamente");
           reservaT++;
           
       }
       
   }
   public void cancelarTurno(){
   
       Scanner scanner = new Scanner(System.in);
       mostrarHorario();
       
       System.out.println("Ingresar numero de la sala:(# -"+salas+ "):");
       int sala = scanner.nextInt();
       
       if(sala<1 || sala>salas){
       
           System.out.println("invalido");
           return; // Salir del método si el número de sala es inválido
       }
       System.out.println("Ingresar numero de ordenador(#- "+pcs+")");
       int ordenador = scanner.nextInt();
       if(ordenador<1 || ordenador>pcs){
       
           System.out.println("invalido");
           return; // Salir del método si el número de sala es inválido
       }
       if(turnos[sala-1][ordenador-1]){
       
           turnos[sala-1][ordenador-1]=false;
           System.out.println("Turno cancelado");
       }else{
       
           System.out.println("El ordenador no esta reservado");
       }
   }
   /*- Cantidad de equipos disponibles por sala
- cantidad de turnos asignados en toda la Facultad*/
   public void mostrarDisponibilidadSalas() {
        System.out.println("Disponibilidad de PCs por sala:");

        for (int i = 0; i < salas; i++) {
            
            int pcsDisponibles = contarPcsDisponiblesEnSala(i);/*
             En cada iteración del bucle, se llama al método 
            contarPcsDisponiblesEnSala(i) para obtener la cantidad de PCs disponibles en la sala actual (i).
            El resultado se almacena en la variable pcsDisponibles.
            */
            System.out.println("Sala " + (i + 1) + ": " + pcsDisponibles + " PCs disponibles");
            /*Se muestra el número de sala (incrementado en 1 para que coincida con la numeración del enunciado del problema)*/
        }
    }

    private int contarPcsDisponiblesEnSala(int sala) {
        int pcsDisponibles = 0;

        for (int j = 0; j < pcs; j++) {
            /*: En cada iteración del bucle, se verifica si la computadora en la posición (sala, j)
            de la matriz turnos no está reservada. False se utiliza para verificar si la computadora está disponible.*/
            if (turnos[sala][j] == false) {
                
                pcsDisponibles++;
            }
        }

        return pcsDisponibles;
    }
    public void mostrarCantidadReservas() {
        System.out.println("Total de reservas realizadas: " + reservaT);
    }
}
