
package com.mycompany.eduardomartineztp2.ventaspromedioregistro;

/*
Se desea cargar el código, nombre, apellido y salario de 20 funcionarios de la
Empresa “Funcional SA” (desde teclado) y sus ventas (generar) de los seis últimos
meses, en un array de tipo registros. Imprimir el código, nombre y apellido, ventas
de los últimos seis meses, y el promedio de ventas por vendedor. 

Imprimir además el promedio de cada mes, nombre y apellido del funcionario con mayor y menor
promedio de ventas, además establecer que aquellos funcionarios que posean
salario inferior al promedio de salarios, serán beneficiados con el 10% de aumento
salarial contar e imprimir cuantos son beneficiados. Crear las clases que sean
necesarias. Además, almacenar en un archivo BENEFICIADOS.TXT todos
aquellos que han obtenido el aumento salarial.
*/


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class EduardoMartinezTP22VentasPromedioRegistro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[20];

        //  cargar los datos de los funcionarios desde el teclado
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("Ingrese datos del funcionario " + (i + 1));
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Salario: ");
            double salario = scanner.nextDouble();

            funcionarios[i] = new Funcionario(codigo, nombre, apellido, salario);
        }

        // generar las ventas de los últimos seis meses
        for (Funcionario funcionario : funcionarios) {
            funcionario.generarVentas(); // Supongamos que hay un método generarVentas() en la clase Funcionario
        }

        // calcular promedios y beneficios salariales
        double sumaVentas = 0;
        int contadorBeneficiados = 0;

        for (Funcionario funcionario : funcionarios) {
            sumaVentas += funcionario.calcularPromedioVentas();

            if (funcionario.getSalario() < funcionario.calcularPromedioSalarios(funcionarios)) {
                funcionario.aumentarSalario(0.10); // Aumento del 10%
                contadorBeneficiados++;
            }
        }

        // imprimir resultados y escribir en el archivo BENEFICIADOS.TXT
        System.out.println("Promedio de ventas por vendedor: " + (sumaVentas / funcionarios.length));
        System.out.println("Funcionarios beneficiados con aumento salarial: " + contadorBeneficiados);

        // Imprimir promedio de ventas por mes
        double sumaVentasMes[] = new double[6];
        for (Funcionario funcionario : funcionarios) {
            for (int i = 0; i < 6; i++) {
                sumaVentasMes[i] += funcionario.getVentas()[i];
            }
        }
        System.out.println("Promedio de ventas por mes:");
        for (int i = 0; i < 6; i++) {
            System.out.println("Mes " + (i + 1) + ": " + (sumaVentasMes[i] / funcionarios.length));
        }

        // Encontrar funcionario con mayor y menor promedio de ventas
        Funcionario funcionarioMayorPromedio = funcionarios[0];
        Funcionario funcionarioMenorPromedio = funcionarios[0];

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.calcularPromedioVentas() > funcionarioMayorPromedio.calcularPromedioVentas()) {
                funcionarioMayorPromedio = funcionario;
            }
            if (funcionario.calcularPromedioVentas() < funcionarioMenorPromedio.calcularPromedioVentas()) {
                funcionarioMenorPromedio = funcionario;
            }
        }

        System.out.println("Funcionario con mayor promedio de ventas:");
        System.out.println("Nombre: " + funcionarioMayorPromedio.getNombre() + " " + funcionarioMayorPromedio.getApellido());
        System.out.println("Promedio de ventas: " + funcionarioMayorPromedio.calcularPromedioVentas());

        System.out.println("Funcionario con menor promedio de ventas:");
        System.out.println("Nombre: " + funcionarioMenorPromedio.getNombre() + " " + funcionarioMenorPromedio.getApellido());
        System.out.println("Promedio de ventas: " + funcionarioMenorPromedio.calcularPromedioVentas());

        // Escribir en el archivo BENEFICIADOS.TXT
        ArchivoBeneficiados.escribirBeneficiados(funcionarios);

        scanner.close();
    }
}

class Funcionario {
    private int codigo;
    private String nombre;
    private String apellido;
    private double salario;
    private double[] ventas;

    public Funcionario(int codigo, String nombre, String apellido, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.ventas = new double[6];
    }

    public void generarVentas() {
        Random random = new Random();

        for (int i = 0; i < ventas.length; i++) {
            ventas[i] = random.nextDouble() * 10000;
        }
    }

    public double calcularPromedioVentas() {
        double sumaVentas = 0;

        for (double venta : ventas) {
            sumaVentas += venta;
        }

        if (ventas.length > 0) {
            return sumaVentas / ventas.length;
        } else {
            return 0;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void aumentarSalario(double porcentaje) {
        salario += salario * porcentaje;
    }

    public double[] getVentas() {
        return ventas;
    }

    public double calcularPromedioSalarios(Funcionario[] funcionarios) {
        double sumaSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            sumaSalarios += funcionario.getSalario();
        }
        return sumaSalarios / funcionarios.length;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

class ArchivoBeneficiados {
    public static void escribirBeneficiados(Funcionario[] funcionarios) {
        try (FileWriter writer = new FileWriter("BENEFICIADOS.TXT")) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getSalario() < funcionario.calcularPromedioSalarios(funcionarios)) {
                    writer.write(funcionario.getNombre() + " " + funcionario.getApellido() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo BENEFICIADOS.TXT: " + e.getMessage());
        }
    }
}
