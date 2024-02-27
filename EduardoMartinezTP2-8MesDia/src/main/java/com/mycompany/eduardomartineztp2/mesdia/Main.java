
package com.mycompany.eduardomartineztp2.mesdia;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Eduardo
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //ingresar el numero del mes
        System.out.println("Ingrese mes: ");
        int mes = scanner.nextInt();
        
        //validar numero
        if(mes <1 ||mes >12){
        
            System.out.println("Invalido");
            
        }
        //ingresar el dia de la semana del primer dia del mes
        System.out.println("ingrese dia de la semana del primer mes");
        char primerDia = scanner.next().charAt(0);
        
        //validar primer dia de la semana
        if(primerDia != 'L' && primerDia != 'M'&& primerDia != 'X'&& primerDia != 'J'
                && primerDia != 'V'&& primerDia != 'S'&& primerDia != 'D'){
            System.out.println("Dia de la semana invalido");
            
        }
        // Crear el calendario y escribirlo en un archivo
         // Crear instancia de DiaMes
        DiaMes diaMes = new DiaMes(mes, primerDia);

        // Llamar al método crearCalendario desde la instancia
        diaMes.crearCalendario(mes, primerDia);


        //Mostrar contenido
        mostrarContenidoArchivo("mes"+mes+".txt");
    }
    
    private static void mostrarContenidoArchivo(String archivo){
    
    
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))){
        
            String linea;
            while((linea = reader.readLine()) != null){
            
                System.out.println(linea);
            }
        }catch(IOException e){
        
            e.printStackTrace();
        }
    }
}
