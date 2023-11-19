package parcial1_2;
/*
 * Complete el codigo faltante y corrija los errores si existe
 * @author cbarua
 */ 

public abstract class Celular_1 implements Navegable {
    
    protected String numero;
    protected String marca;
    protected String tecnologia;
    protected int costoMin;
    protected int minutos;
    public static final String[] TECNOLOGIAS = {"2G","3G","4GLTE","5G"};

    public Celular_1() {
    }

    public Celular_1(String numero, String marca, String tecnologia, int costo) {
        this.marca = marca;
        this.numero = numero;
        this.tecnologia = tecnologia;
        this.costoMin = costo;
    }
     public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public abstract int calcularCostoLlamada();//metodo que es polimorfico
     
    public String llamar(String numero) {//metodo que puede ser polimorfico
        int minutosLlamados = (int) (Math.random() * 60); // Genera aleatoriamente la cantidad de minutos llamados
        this.minutos += minutosLlamados;
        return "Llamando a " + numero + " por " + minutosLlamados + " minutos.";
    }
   
    public String recibirLlamada(String numero) {//puede ser polimorfico
        return "Llamada recibida de " + numero;
    }

    @Override
    public String toString() {
        return numero + " marca: " + marca + ", Tecnologia: " + tecnologia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getCostoMin() {
        return costoMin;
    }

    public void setCostoMin(int costoMin) {
        this.costoMin = costoMin;
    }
    
}
