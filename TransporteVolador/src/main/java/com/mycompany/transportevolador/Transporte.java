/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportevolador;

/**
 *
 * @author Eduardo
 */
public abstract class Transporte implements Volador{
     // Propiedades
    protected String marca;
    protected String modelo;
   
    protected double velocidadMaxima;

    public Transporte() {
    }

   

    public Transporte(String marca, String modelo,  double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    

   

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    @Override
    public String toString() {
        return "Transporte{" + "marca=" + marca + ", modelo=" + modelo +  ", velocidadMaxima=" + velocidadMaxima + '}';
    }
    
    
}
