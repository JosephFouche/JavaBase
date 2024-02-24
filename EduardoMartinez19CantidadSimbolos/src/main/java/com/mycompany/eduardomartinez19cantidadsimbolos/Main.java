
package com.mycompany.eduardomartinez19cantidadsimbolos;

import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class Main {
     
        public static void main(String[] args) {
            // Crear un objeto Scanner para leer la entrada del usuario
            Scanner scanner = new Scanner(System.in);

            // Pedir al usuario que ingrese una frase
            System.out.print("Ingresa una frase: ");
            String frase = scanner.nextLine();

            // Crear un objeto ContadorCaracteres y mostrar los resultados
            ContadorCaracteres contador = new ContadorCaracteres(frase);
            contador.mostrarResultados();

            // Cerrar el objeto Scanner para liberar recursos
            scanner.close();
        }
}

