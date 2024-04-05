package parcial1;


import java.util.Scanner;

/**
 * Test Parcial1
 * @author cbarua
 * Alumno EDUARDO MARTINEZ 5499630
 */
public class TestParcial1 {
    AlumnoGrado[] alumnos;

    public TestParcial1() {
        alumnos = new AlumnoGrado[2];
        
        Materia[] mats1 = {new Materia("001", "Estructura de Datos", 78),
                           new Materia("002", "Fisica", 56),
                           new Materia("003", "Algoritmica 1", 89)};
        Materia[] mats2 = {new Materia("001", "Estructura de Datos", 78),
                           new Materia("004", "Ingles", 100),
                           new Materia("005", "Calculo", 90),
                           new Materia("006", "Sistemas Operativos", 100)};
        
        alumnos[0] = new AlumnoGrado("Lcik", 0, "fpuna", mats1, 567567, "Pedro", 0, 0); // Aquí debes ajustar los últimos dos argumentos según sea necesario
        alumnos[1] = new AlumnoGrado("Lcik", 0, "fpuna", mats2, 56757, "Ana", 0, 0); // Aquí también
        
        Materia mats[] = new Materia[3];
        mats[0] = new Materia("001", "Estructura de Datos",78);
        mats[1] = new Materia("002", "Fisica",56);
        mats[2] = new Materia("003", "Algoritmica 1",89);
       
        procesar(alumnos[0], mats);
        procesar(alumnos[1], mats);
    }

    public static void main(String[] args) {
        new TestParcial1();
    }

    private void procesar(AlumnoGrado ag, Materia[] mats) {
        System.out.println(ag);
        System.out.println("Calculando Monto Deuda: " + ag.calcularDeudar());
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el monto a pagar: ");
        int monto = sc.nextInt();
        System.out.println(ag.pagarCuota(monto));
        sc = new Scanner(System.in);
        System.out.print("Ingrese el código de la materia a rendir: ");
        String m = sc.nextLine();
        System.out.println(ag.darExamen(m));
        System.out.println(ag);
        System.out.println("");
    }
}
   

   

