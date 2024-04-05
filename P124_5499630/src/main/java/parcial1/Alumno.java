/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

/**
 *
 * @author Fpuna
 * 
 * Alumno EDUARDO MARTINEZ 5499630
 */
public abstract class Alumno extends Persona{
    protected String institucion;
    protected Materia[] materias;

    public Alumno(String institucion, Materia[] materias, int ci, String nombre) {
        super(ci, nombre);
        this.institucion = institucion;
        this.materias = new Materia[10]; // O el tamaño adecuado para tu aplicación
    }

    public Alumno(String institucion, Materia[] materias, int ci, String nombre, int edad, float peso) {
        super(ci, nombre, edad, peso);
        this.institucion = institucion;
        this.materias = materias;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alumno{" +
                "nombre='" + nombre + '\'' +
               
                ", institucion='" + institucion + '\'' +
                ", materias=\n");
        for (Materia materia : materias) {
            if (materia != null)
                sb.append(materia).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }
    

  
  /*Agregue dos métodos públicos y abstractos:
int calcularDeuda() y int darExamen(String cod);*/
    public abstract int calcularDeudar();
    public abstract int darExamen(String cod);
    
  
    
}
