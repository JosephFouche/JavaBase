/*
Escribir un programa que permita ingresar por teclado una frase y cuente la
cantidad de palabras, vocales, consonantes y símbolos. Utilizar un vector para
almacenar los resultados. Imprimir todos los resultados.
 */

package com.mycompany.eduardomartinez19cantidadsimbolos;
import java.util.Scanner;


    

public class ContadorCaracteres {
    private String frase;
    private int[] resultados;

    public ContadorCaracteres(String frase) {
        this.frase = frase;
        this.resultados = new int[4];
        contarCaracteres();
    }

    public void mostrarResultados() {
        System.out.println("Resultados:");
        System.out.println("Vocales: " + resultados[0]);
        System.out.println("Consonantes: " + resultados[1]);
        System.out.println("Símbolos: " + resultados[2]);
        System.out.println("Palabras: " + resultados[3]);
    }

    private void contarCaracteres() {
        int largoFrase = frase.length();
        String[] palabras = frase.split("\\s+");
        boolean enPalabra = false;

        for (int i = 0; i < largoFrase; i++) {
            char caracter = frase.charAt(i);

            if (esVocal(caracter)) {
                resultados[0]++; // Vocales
            } else if (esConsonante(caracter)) {
                resultados[1]++; // Consonantes
            } else if (!Character.isWhitespace(caracter)) {
                resultados[2]++; // Símbolos
            }

            // Verificar si estamos en una palabra
            if (Character.isLetter(caracter) && !enPalabra) {
                enPalabra = true;
                resultados[3]++; // Palabras
            } else if (Character.isWhitespace(caracter)) {
                enPalabra = false;
            }
        }
        resultados[3] = palabras.length; // Palabras
    }

    private static boolean esVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    private static boolean esConsonante(char c) {
        return Character.isLetter(c) && !esVocal(c);
    }
}

   

