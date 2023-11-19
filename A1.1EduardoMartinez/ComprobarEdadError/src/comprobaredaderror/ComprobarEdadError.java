
package comprobaredaderror;

/*
Ejecute el siguiente programa y verifique si funciona adecuadamente. En caso que no, corrija los errores
necesarios para que funcione como se espera: Debe imprimir un mensaje si el usuario tiene 37 años:

*/
import java.util.Scanner;
public class ComprobarEdadError {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese su edad: ");
        int edad = s.nextInt();
        if (edad == 37){//error en la condicion, se debe borrar el cero 
            System.out.println("Felicidades... cumples las condiciones de cumplir 37 años");
            
        }else{
            System.out.println(":(No cumples con la condicion de tener 37 años");
        }
    }
    
}
