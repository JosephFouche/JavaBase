
package numerotablamultiplicar;

/*
 Escriba un programa Java que permita recibir del usuario un número entero de un solo dígito y genere la
tabla de multiplicación de dicho número. La impresión de la tabla debe hacerse con print
 */
import java.util.Scanner;
public class NumeroTablaMultiplicar {

    
    public static void main(String[] args) {
        
        Scanner sc =  new Scanner(System.in);
        /*
        es una clase en Java que se utiliza para leer la entrada del usuario
        desde la consola o para leer archivos y cadenas. 
        */
        System.out.print("Ingrese numero entero de un solo digito: ");
        int numero = sc.nextInt();
        /*
       metodo nextInt(): Lee un entero de la entrada del usuario.
        */
        if(numero >= 0 && numero <= 9){
            System.out.println("Tabla de multiplicar de  "+numero+ ":");
            for(int i = 1; i<=10; i++){
                System.out.println(numero+ "x" + i+ " = "+(numero*i));
            }
            
        }else{
            System.out.println("El numero debe ser de rango (1-9)");
        }
        sc.close();
    }
    
}
