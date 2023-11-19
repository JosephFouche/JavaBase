
package com.mycompany.archivolistalarga;

/*
Se tiene un archivo de texto con una lista larga de palabras (varias repetidas). Cada línea de texto
puede tener muchas palabras y el archivo puede tener muchas líneas. Escriba un programa Java que permita
recibir del usuario un nombre de archivo de texto (con la ruta absoluta) y genere en pantalla el listado de las 10
palabras del archivo que más veces se repite. Por cada palabra se debe imprimir al lado la cantidad de
repeticiones. Debe contemplar posibles errores mediante manejo de excepciones.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ArchivoListaLarga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la ruta absoluta del archivo de texto: ");
        String filePath = scanner.nextLine();

        try {
            Map<String, Integer> wordFrequency = getWordFrequency(filePath);
            List<Map.Entry<String, Integer>> sortedList = sortWordFrequency(wordFrequency);

            System.out.println("Palabra\t\tRepeticiones");
            System.out.println("-----------------------");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.printf("%-15s%d%n", entry.getKey(), entry.getValue());
                count++;
                if (count == 10) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    private static Map<String, Integer> getWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();  // Convertir a minúsculas para contar sin distinción de mayúsculas
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordFrequency;
    }

    private static List<Map.Entry<String, Integer>> sortWordFrequency(Map<String, Integer> wordFrequency) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        return sortedList;
    }
}

