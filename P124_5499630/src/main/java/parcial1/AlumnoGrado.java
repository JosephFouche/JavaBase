/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial1;

import java.util.Random;

/**
 *
 * @author Fpuna
 * Alumno EDUARDO MARTINEZ 5499630
 */
public class AlumnoGrado extends Alumno {
    
    private String carrera;
    private int montoDeuda;
    //definir constante
    public static final int CUOTA = 30000;

    public AlumnoGrado(String carrera, int montoDeuda, String institucion, Materia[] materias, int ci, String nombre) {
        super(institucion, materias, ci, nombre);
        this.carrera = carrera;
        this.montoDeuda = 0;
    }

    public AlumnoGrado(String carrera, int montoDeuda, String institucion, Materia[] materias, int ci, String nombre, int edad, float peso) {
        super(institucion, materias, ci, nombre, edad, peso);
        this.carrera = carrera;
        this.montoDeuda = 0;
    }

   

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(int montoDeuda) {
        this.montoDeuda = montoDeuda;
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

   
    
 

    
  

   

   
    

   
//. La deuda se calcula de acuerdo a la cantidad de materias por la CUOTA
    @Override
    public int calcularDeudar() {
    
         int totalMaterias = 0;
         for(int i=0; i<materias.length;i++){
             if(materias[i]!=null){//si valor en indice i diferente de 0, contar
             
                 totalMaterias++;
             }
         }
         montoDeuda = totalMaterias*CUOTA;//total contado por CUOTA
         return montoDeuda;
    }
//debe buscar el código de la materia entre 
//las materias del alumno y asignarle un puntaje aleatoriamente entre 0 y 100. 
    @Override
    public int darExamen(String cod) {///representa el código de la materia en la que el alumno va a rendir el examen. 
        //Retorna un entero que representa el puntaje obtenido en el examen.
        //puntaje aleatorio entre 0 y 100
        Random r = new Random();
        int puntaje = r.nextInt(101);//puntaje entre 0 y 100
        for(int i =0; i<materias.length;i++){//Se itera sobre el arreglo materias, que contiene las materias en las que el alumno está inscrito.
            Materia materia = materias[i];// En cada iteración, se obtiene una materia del arreglo materias.
            if(materia!=null && materia.getCodigo().equals(cod)){/*Se verifica si la materia actual no es nula 
                y si su código coincide con el código de la materia pasada como parámetro.
                
                */
                materia.setPuntaje(puntaje);// Si se encuentra la materia correspondiente al código proporcionado,
                //se establece el puntaje obtenido en el examen para esa materia
                return puntaje;//Se retorna el puntaje obtenido en el examen.
                
            }
        }
        
     return 0;
     /*Si no se encuentra la materia correspondiente al código proporcionado, 
     o si el arreglo materias está vacío, se retorna 0, lo que indica que el alumno no rindió el examen en esa materia.*/
    }
    
    /*) que recibe un monto y descuenta del montoDeuda. 
    El saldo después de pagar no puede ser negativo. 
    El método debe retornar una cadena como el siguiente: 
    Monto pagado: 90000 Saldo: 30000 */
    public String pagarCuota(int monto){
       //int pagar = monto-CUOTA;
       int saldo = montoDeuda -monto;
       
       if(saldo<0){
       return "Error";}
       montoDeuda = saldo;
       
        return ("MONTO PAGADO: "+monto+"SALDO: "+montoDeuda);
    }
     @Override
    public String toString() {
        return "AlumnoGrado{" + "carrera=" + carrera + ", montoDeuda=" + montoDeuda +", " + super.toString() +
                '}';
    }
}
