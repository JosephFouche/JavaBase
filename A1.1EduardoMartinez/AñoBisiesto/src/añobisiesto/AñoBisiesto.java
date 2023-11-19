
package añobisiesto;
import java.util.Scanner;

/*
Escriba un programa Java que contenga un método estático que pueda recibir un número entero que
representa a un año, y retorne true o false dependiendo de si el año es o no bisiesto.
Para saber si un año es bisiesto se puede aplicar una simple fórmula, la cual dice que un
año es bisiesto si es divisible por cuatro, excepto los principios de año (los divisibles por 100),
que para ser bisiestos deben de ser divisibles también por 400.
 */
public class AñoBisiesto {
       
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese anio: ");
        int anio = sc.nextInt();
        
        if(bisiesto(anio)){
            System.out.println("Es anio bisiesto");
        }else{
            System.out.println("No es bisiesto");
        }
    }
     public static boolean bisiesto(int anho){    
        return ((anho % 4==0)&&((anho % 100 != 0)||(anho %400==0)));
    }    
}
