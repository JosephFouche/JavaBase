
package diasemananumero;

/*
 Escriba un programa Java que reciba del teclado un número del 1 al 7 e imprima el día de la semana
correspondiente. Debe usarse switch y si el usuario ingresa un nro fuera del rango 1-7. 
Mostrar un mensaje de error y volver a pedir el dato.
 */
import java.util.Scanner;
public class DiaSemanaNumero {

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
         
        int dia;
       do{
           System.out.print("Ingrese numero de la semana: ");
           dia = sc.nextInt();
       
                switch(dia) {

                case 1:
                  System.out.println("Hoy es lunes.");
                  break;
                case 2:
                  System.out.println("Hoy es martes.");
                  break;
                case 3:
                  System.out.println("Hoy es miercoles.");
                  break;
                case 4:
                  System.out.println("Hoy es jueves.");
                  break;
                case 5:
                  System.out.println("Hoy es viernes.");
                  break;
                case 6:
                  System.out.println("Hoy es sabado.");
                  break;
                case 7:
                  System.out.println("Hoy es domingo.");
                  break;
                default:
                  System.out.println("Numero ingresado incorrecto.");
                  
                  


             }
       }while(dia<1 || dia >7);
       sc.close();
    }
    
}
