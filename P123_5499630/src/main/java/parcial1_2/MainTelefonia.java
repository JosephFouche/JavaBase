package parcial1_2;

/**
 * Aplicación para probar las clases creadas
 * @author Claudio Barua
 */
public class MainTelefonia {
    Celular_1 c;

    public MainTelefonia() {
        c = new Smartphone("0961 123456", "Samsung", "4G", 200, "Android");
        c.llamar("0983 987456");
        System.out.println("Total de minutos de la llamada: " + c.getMinutos());
        procesar(c);

        c = new LineaAlta("021 123654", "Motorola", "3G", 190, "900");
        c.llamar("0983 987456");
        System.out.println("Total de minutos de la llamada: " + c.getMinutos());
        procesar(c);
    }

    /**
     * Agrega el método procesar solicitado, que debe recibir un objeto Celular.
     * Debe imprimir lo que devuelve los siguientes métodos: toString,
     * calcularCostoLlamada y navegar.
     * Al final imprima una línea vacía.
     */
    public void procesar(Celular_1 celular) {
        System.out.println(celular.toString());
        if (celular instanceof Navegable) {
            Navegable navegable = (Navegable) celular;
            System.out.println("Navegando: " + navegable.navegar("https://www.example.com"));
        }
        System.out.println("Costo de llamada: " + celular.calcularCostoLlamada());
        System.out.println();
    }

    public static void main(String[] args) {
        new MainTelefonia();
    }
}
