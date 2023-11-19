/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author EMG73
 */
public class ColaVaciaException extends Exception{
    public ColaVaciaException() {
        super("La cola esta vacia");
    }
}
