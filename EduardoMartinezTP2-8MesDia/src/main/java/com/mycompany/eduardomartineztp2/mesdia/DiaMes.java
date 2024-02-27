

package com.mycompany.eduardomartineztp2.mesdia;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/*
Escribir un programa que reciba por parámetro el número correspondiente a un
mes del año y la letra correspondiente al día de la semana en que cae el día 1 de
ese mes (‘L’ para Lunes, ‘M’ para Martes, ‘X’ para Miércoles…). Cree un método
que escribirá en un archivo un calendario para ese mes que estará formado por
todos los días del mes seguidos de la letra correspondiente al día de la semana en
que caen. El método comprobará que los parámetros recibidos son correctos y
obtendrá el nombre concatenando a la palabra “mes” el número de mes recibido
más la extensión “.txt”.
Ejemplo: Si el método recibe el valor 3 (Marzo) y la letra ‘M’ indicando que el 1
de Marzo es Martes, obtendrá el nombre de archivo “mes3.txt” y lo escribirá con
un calendario que tendrá un aspecto como éste:
1M
2X
3J
5V
6S
7D
8L
…
31J
 * @author Eduardo
 */


public class DiaMes {

    public int mes;
    public char dia;
    
    public DiaMes(int mes, char dia) {
        this.mes = mes;
        this.dia = dia;
    }
    public void crearCalendario(int mes, char primerDia){
       //Nombre de los días de la semana
       String[] diasSemana ={"L","M","X","J","V","S","D"};
       // Nombres de los meses
        String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
                "Octubre", "Noviembre", "Diciembre"};
       //Numero de dias de cada mes
       int[] diasMes = {0,30,30,30,30,30,30,30,30,30,30,30,30};
       
       //seleccionar numero de dias
       int numDias = diasMes[mes];
       //como saber que índice del primer dia es
       int indicePrimerDia = 0;
       for (int i = 0; i < diasSemana.length; i++) {
            if (diasSemana[i].charAt(0) == primerDia) {
                indicePrimerDia = i;
                break;
            }
        }
       
       //Crear y escribir en el archivo
       String archivo = "mes"+mes+".txt";
       try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))){
       
           writer.write(meses[mes]+"\n");
           //Escribir los encabezados de los dias de la semana
           for(String dia: diasSemana){
           
               writer.write(dia +"\t");
           }
           writer.write("\n");
           for(int i=0; i<indicePrimerDia;i++){
           
               writer.write("\t");
           }
           //Escribir los dias del mes
           for(int dia = 1; dia <= numDias;dia++){
           
               writer.write(dia+ diasSemana[indicePrimerDia %7]+"\t");
               
               //Avanzar al siguiente dia de la semana
               indicePrimerDia++;
               if(dia%7==0){
               
                   writer.write("\n");
               }
           }
       } catch(IOException e){
       
           e.printStackTrace();
       }
    }
    /*private static boolean esDia(char c) {
        return "lmxjvsdLMXJVSD".indexOf(c) != -1;
    }*/
   
}
