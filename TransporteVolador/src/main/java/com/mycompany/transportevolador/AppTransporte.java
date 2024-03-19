/*
Descargar de Educa la clase AppTransporte. Agregar la clase al paquete. Crear un array de Transportes de
4 posiciones.
 Agregar un método void procesar (Transporte t). Aquí se debe imprimir los datos del transporte invocando
a los métodos toString. Invocar, además, los métodos de la interface (3p).
 En el constructor de la clase AppTransporte, instanciar 2 transportes diferentes, cargar en el array creado
y llamar al método procesar pasándole el elemento del array (3p)

*/
package com.mycompany.transportevolador;

public class AppTransporte extends Transporte implements Volador {
    
    public static void main(String[] args) {
        // Crear instancia de la clase AppTransporte
        AppTransporte app = new AppTransporte();
        // Crear un array de Transportes de 4 posiciones
        /*Se crea un array llamado transportes que puede contener hasta 4 objetos de tipo Transporte.
        Este array está inicializado con 4 posiciones, pero aún no contiene ningún objeto.*/
        Transporte[] transportes = new Transporte[4];
        
        // Instanciar 4 transportes diferentes y cargarlos en el array
        transportes[0] = new Avion("Boeing", "747", 300, 900);
        transportes[1] = new Helicoptero("Bell", "Huey", 250,"rescate");
        transportes[2] = new Avion(300,true,"Paraguay","108",700.8);
        transportes[3]= new Helicoptero("Bell","falcon",350,"militar");
        
        // Llamar al método procesar pasándole el elemento del array
        for (Transporte transporte : transportes) {
            if (transporte != null) {
                app.procesar(transporte);
            }
        }
    }
    
    // Constructor de la clase AppTransporte

    public AppTransporte() {
    }

    public AppTransporte(String marca, String modelo, double velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    
    
   

    // Método para procesar un transporte
    public void procesar(Transporte t) {
        // Imprimir los datos del transporte utilizando el método toString
        System.out.println(t.toString());
        
        // Invocar los métodos de la interfaz Volador
        System.out.println(t.despegar());
        System.out.println(t.volar(100)); // Supongamos que el transporte vuela 100 km
        System.out.println(t.aterrizar());
    }
    
    // Implementación de los métodos de la interfaz Volador
    public String despegar() {
        return "Despegando...";
    }

    public String volar(float km) {
        return "Volando " + km + " kilómetros...";
    }

    public String aterrizar() {
        return "Aterrizando...";
    }
}