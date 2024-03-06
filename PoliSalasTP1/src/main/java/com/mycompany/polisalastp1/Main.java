
package com.mycompany.polisalastp1;
import java.util.Scanner;
/**
 *
 * @author Eduardo
 */
public class Main {
    public static void main(String[] args) {
        
        
        //crear instancia
    PoliSalasTP1 polisalas = new PoliSalasTP1(5,20);
    
    Scanner scanner = new Scanner(System.in);
    
    while(true){

    
            System.out.println("Seleccionar opcion: ");
            System.out.println("1- Reservar");
            System.out.println("2- Cancelar");
            System.out.println("3- Mostrar Diponibilidad");
            System.out.println("4 -Mostrar Cantidad de Reservas");
            System.out.println("5- Salir");
            
            int opcion = scanner.nextInt();
            
            switch(opcion){
            
                case 1: 
                    polisalas.reservarTurno();
                    break;
                case 2: 
                    polisalas.cancelarTurno();
                    break;
                case 3:
                    polisalas.mostrarDisponibilidadSalas();
                    break;
                case 4:
                    polisalas.mostrarCantidadReservas();
                case 5:
                    System.out.println("Chau!!");
                    System.exit(0);
                default:
                    System.out.println("Invalido. try again");
                            
            }
    }
        
   }
}
   
