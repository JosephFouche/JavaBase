package parcial1;


/**
 * TDA Persona
 * @author cbarua
 * Alumno EDUARDO MARTINEZ 5499630
 */
public abstract class Persona {
    protected int ci;
    protected String nombre;
    protected byte edad;
    protected float peso;

    public Persona() {
        nombre = "NN";
    }

    public Persona(int ci, String nombre) {
        this.ci = ci;
        this.nombre = nombre;
    }

    public Persona(int ci, String nombre, int edad, float peso) {
        this.ci = ci;
        this.nombre = nombre;
        this.edad = (byte)edad;
        this.peso = peso;
    }

    
    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = (byte)edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return ci + ", " + nombre + ", " + edad + "anhos, " + peso + "k";
    }
    
    public String comer(String comida, float cant){
        peso += cant * 0.0001;
        return "Comiendo " + comida + " " + cant + " grs.";
    }
    
    public String caminar(int cantPasos) {
        peso -= cantPasos / 20000f;
        return "Caminando " + cantPasos + " pasos";
    }

}
