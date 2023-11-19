

package com.mycompany.eduardomartineztp4.cajeroautomatico;

/*

a) Implementar una estructura ColaEstatica siguiendo la
InterfaceColaEstatica.java que se encuentra en Recursos de Educa. El frente de
la cola siempre será la posición 0 del array, cada vez que se atiende un
elemento, los demás se corren hacia el frente.
La estructura debe manejar datos genéricos y excepciones.

b) Crear una aplicación que permita simular el funcionamiento de una fila frente a
dos cajeros automáticos (ATM que sólo acepta depósitos) de un banco. La
aplicación debe mostrar un menú para: 1) Insertar personas a la cola, 2) Atender
una persona de la cola (mostrar su nombre y el monto a depositar), 3) Mostrar los
datos de la próxima persona a ser atendida, 4) Mostrar el total de personas en la
cola, 5) Mostrar la cantidad de personas atendidas por cada ATM, 6) Mostrar el
monto depositado en cada ATM y 0) Finalizar la aplicación (mostrar un resumen
de las operaciones realizadas y personas atendidas).

La aplicación debe solicitar, al inicio de la misma, el tamaño de cada cola.
La clase Persona.java debe tener las propiedades privadas int codigo, int monto;
agregar los métodos constructores, set, get y toString, necesarios. Crear la clase
ATM (byte id, int montoDepositado). El monto a depositar se genera
aleatoriamente. Cada persona puede depositar entre 50.000 y 5.000.000 Gs, en
billetes de 2, 5, 10, 20, 50 y 100mil. La caja que atenderá a una persona se elige
aleatoriamente.
 */
import Excepciones.ColaLlenaException;
import Excepciones.ColaVaciaException;
import java.util.Random;
import java.util.Scanner;
public class EduardoMartinezTP49CajeroAutomatico {

    public static void main(String[] args) throws ColaVaciaException, ColaLlenaException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la cola para Cajero 1: ");
        int tamanoColaCajero1 = scanner.nextInt();
        System.out.print("Ingrese el tamaño de la cola para Cajero 2: ");
        int tamanoColaCajero2 = scanner.nextInt();
        
        

        InterfaceColaEstatica<Persona> colaCajero1 = new ColaEstatica<>(tamanoColaCajero1);
        InterfaceColaEstatica<Persona> colaCajero2 = new ColaEstatica<>(tamanoColaCajero2);
// Crear los objetos ATM para cada cajero
        ATM atmCajero1 = new ATM((byte) 1);
        ATM atmCajero2 = new ATM((byte) 2);
        Random random = new Random();
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1) Insertar persona a la cola");
            System.out.println("2) Atender persona de la cola");
            System.out.println("3) Mostrar próxima persona a ser atendida");
            System.out.println("4) Mostrar total de personas en la cola");
            System.out.println("5) Mostrar cantidad de personas atendidas por cada ATM");
            System.out.println("6) Mostrar monto depositado en cada ATM");
            System.out.println("0) Finalizar la aplicación");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    String nombre = "Persona" + (colaCajero1.size() + colaCajero2.size() + 1);
                    double monto = generateRandomMonto();
                    int cajeroAleatorio = random.nextInt(2);

                    Persona persona = new Persona(nombre, monto);
                    if (cajeroAleatorio == 0) {
                        if (!colaCajero1.isFull()) {
                            colaCajero1.insertar(persona);
                            System.out.println("Persona " + nombre + " agregada a la cola del Cajero 1.");
                        } else {
                            System.out.println("La cola del Cajero 1 está llena. No se puede agregar más personas.");
                        }
                    } else {
                        if (!colaCajero2.isFull()) {
                            colaCajero2.insertar(persona);
                            System.out.println("Persona " + nombre + " agregada a la cola del Cajero 2.");
                        } else {
                            System.out.println("La cola del Cajero 2 está llena. No se puede agregar más personas.");
                        }
                    }
                    break;

                case 2:
                    if (!colaCajero1.isEmpty()) {
                        Persona personaAtendida1 = colaCajero1.atender();
                        System.out.println("Atendiendo en Cajero 1: " + personaAtendida1);
                        atmCajero1.depositar((int) personaAtendida1.getMonto());// Registra el monto depositado en Cajero 1
                    }
                    if (!colaCajero2.isEmpty()) {
                        Persona personaAtendida2 = colaCajero2.atender();
                        System.out.println("Atendiendo en Cajero 2: " + personaAtendida2);
                        atmCajero2.depositar((int) personaAtendida2.getMonto()); // Registra el monto depositado en Cajero 2
                    }
                    break;

                case 3:
                    if (!colaCajero1.isEmpty()) {
                        System.out.println("Próxima persona a ser atendida en Cajero 1: " +
                                colaCajero1.consultar());
                    }
                    if (!colaCajero2.isEmpty()) {
                        System.out.println("Próxima persona a ser atendida en Cajero 2: " +
                                colaCajero2.consultar());
                    }
                    break;

                case 4:
                    System.out.println("Total de personas en la cola de Cajero 1: " + colaCajero1.size());
                    System.out.println("Total de personas en la cola de Cajero 2: " + colaCajero2.size());
                    break;

                case 5:
                    System.out.println("Cantidad de personas atendidas por Cajero 1: " + (tamanoColaCajero1 - colaCajero1.size()));
                    System.out.println("Cantidad de personas atendidas por Cajero 2: " + (tamanoColaCajero2 - colaCajero2.size()));
                    break;

                case 6:
                    System.out.println("Monto depositado en Cajero 1: " + atmCajero1.getMontoDepositado());
                    System.out.println("Monto depositado en Cajero 2: " + atmCajero2.getMontoDepositado());
                    
                    break;

                case 0:
                    
                    // Mostrar un resumen de las operaciones realizadas y personas atendidas
                    System.out.println("Resumen de la aplicación:");
                    System.out.println("Total de personas en la cola de Cajero 1: " + colaCajero1.size());
                    System.out.println("Total de personas en la cola de Cajero 2: " + colaCajero2.size());

                    System.out.println("Cantidad de personas atendidas por Cajero 1: " + (tamanoColaCajero1 - colaCajero1.size()));
                    System.out.println("Cantidad de personas atendidas por Cajero 2: " + (tamanoColaCajero2 - colaCajero2.size()));

                    System.out.println("Monto depositado en Cajero 1: " + atmCajero1.getMontoDepositado());
                    System.out.println("Monto depositado en Cajero 2: " + atmCajero2.getMontoDepositado());

                    // Salir de la aplicación
                    System.out.println("La aplicación ha finalizado. ¡Hasta luego!");
                    System.exit(0); // Sale de la aplicación con un código de salida 0
                    break;


                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private static double generateRandomMonto() {
        Random random = new Random();
        double minMonto = 50000;
        double maxMonto = 5000000;
        int[] billetes = {2, 5, 10, 20, 50, 100};

        double randomMonto = minMonto + (maxMonto - minMonto) * random.nextDouble();
        return billetes[random.nextInt(billetes.length)] * (int) (randomMonto / billetes[random.nextInt(billetes.length)]);
    }
}

class Persona {
    private String nombre;
    private double monto;

    public Persona(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Monto a depositar: " + monto;
    }
}

class ATM {
    private byte id;
    private int montoDepositado;

    public ATM(byte id) {
        this.id = id;
        this.montoDepositado = 0;
    }

    public int getMontoDepositado() {
        return montoDepositado;
    }

    public void depositar(int monto) {
        montoDepositado += monto;
    }
}






    

