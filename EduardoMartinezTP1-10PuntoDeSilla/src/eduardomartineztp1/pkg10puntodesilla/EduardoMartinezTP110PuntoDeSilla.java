
package eduardomartineztp1.pkg10puntodesilla;

/*
10.
Se dice que una matriz tiene un punto de silla si alguna posición de la matriz es
el menor valor de su fila y a la vez el mayor de su columna. Escribir un programa
que tenga como entrada una matriz de números enteros y calcule la posición de
un punto de silla (si es que existe). Generar 25 números comprendidos entre 100
y 999. Cargar en un array A de 5 columnas y 5 filas.
 */

import java.util.Scanner;
import java.util.Random;

public class EduardoMartinezTP110PuntoDeSilla {

    public static void main(String[] args) {
        int fila = 5;
        int columna = 5;
        int[][] matriz =  new int[fila][columna];
        boolean puntoSilla = false; //booleano tiene por determinado valor falso
        int menorFila;
        int mayorColumna;
        Random rand = new Random();    //constructor random
        
    for (int i = 0; i < fila; i++) {
        for (int j = 0; j < columna; j++) {
                matriz[i][j] = rand.nextInt(999) + 100;// se generan aleatoriamente numeros del 100 al 999.
        }
    }
        
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print("\t" + matriz[i][j]);//imprimir Matriz
            }
            System.out.println();
        }
        
        
        for (int i = 0; i < fila; i++) {
            /*
            i itera a través de las filas de la matriz
            menorFila se inicializa con el primer elemento de  fila actual (matriz[i][0]).
            mc (columna del valor mínimo) se inicializa en 0.
            */
            menorFila = matriz[i][0];
            int mc = 0;

            for (int j = 1; j < columna; j++) {
                if (matriz[i][j] < menorFila) {
                    /*
                    j itera a través de las columnas de la fila actual.
                    Compara cada elemento matriz[i][j] con menorFila y,
                    si es menor, actualiza menorFila y la columna mc con j.
                                   
                    */
                    menorFila = matriz[i][j];
                    mc = j;
                }
            }
            /*
            mayorColumna se inicializa con el primer elemento de la columna correspondiente a mc (matriz[0][mc]).
            kSilla se inicializa en 0 y se usará para mantener el índice de fila con el mayor valor en la columna.
            */
            mayorColumna = matriz[0][mc];
            int kSilla = 0; // Variable para mantener el valor de 'k'
            for (int k = 1; k < fila; k++) {
                /*
                k itera a través de las filas, comenzando desde la segunda fila.
                Compara cada elemento matriz[k][mc] con mayorColumna y,
                si es mayor, actualiza mayorColumna y kSilla con k.
                */
                if (matriz[k][mc] > mayorColumna) {
                    mayorColumna = matriz[k][mc];
                    kSilla = k;
                }
            }

            if (menorFila == mayorColumna) {
                /*
                Compara menorFila con mayorColumna. Si son iguales, encontramos un punto de silla en la fila i y columna mc.
                Si se encuentra un punto de silla, se muestra un mensaje y se establece puntoSilla como true.

                */
                System.out.println("Hay punto de silla en fila " + i + " y columna " + mc + " con valor de " + mayorColumna);
                puntoSilla = true;
            }
        }

        if (!puntoSilla) {
            /*
            no se encontró ningún punto de silla,
             mostrar un mensaje  que no hay punto de silla.
            */
            System.out.println("No hay punto de silla");
        }
    }
}