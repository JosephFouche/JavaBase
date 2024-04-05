/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

/**
 *
 * @author Fpuna
 * Alumno EDUARDO MARTINEZ 5499630
 */
public class Materia {
    private String codigo;
    private String nombre;
    private int puntaje;

    public Materia() {
    }

    public Materia(String codigo, String nombre, int puntaje) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Materia{" + "codigo=" + codigo + ", nombre=" + nombre + ", puntaje=" + puntaje + '}';
    }
    
}
