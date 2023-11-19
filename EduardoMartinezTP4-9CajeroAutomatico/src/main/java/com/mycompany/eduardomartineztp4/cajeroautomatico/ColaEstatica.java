/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eduardomartineztp4.cajeroautomatico;

/**
 *
 * @author EMG73
 */


import Excepciones.ColaLlenaException;
import Excepciones.ColaVaciaException;

public class ColaEstatica<T> implements InterfaceColaEstatica<T> {
    private Object[] cola;
    private int capacidad;
    private int frente;
    private int fin;
    private int cantidadElementos;

    public ColaEstatica(int cantElementos) {
        this.capacidad = cantElementos;
        this.cola = new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.cantidadElementos = 0;
    }

    @Override
    public void iniciar(int cantElementos) {
        this.capacidad = cantElementos;
        this.cola = new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.cantidadElementos = 0;
    }

    @Override
    public void insertar(T elemento) throws ColaLlenaException {
        if (isFull()) {
            throw new ColaLlenaException();
        }

        fin = (fin + 1) % capacidad;
        cola[fin] = elemento;
        cantidadElementos++;
    }

    @Override
    public T atender() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException();
        }

        T elemento = (T) cola[frente];
        cola[frente] = null;
        frente = (frente + 1) % capacidad;
        cantidadElementos--;
        return elemento;
    }

    @Override
    public T consultar() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException();
        }

        return (T) cola[frente];
    }

    @Override
    public int buscar(T dato) {
        for (int i = 0; i < capacidad; i++) {
            if (cola[i] != null && cola[i].equals(dato)) {
                return i + 1; // Devuelve la posición basada en 1
            }
        }
        return 0; // No se encontró el dato en la cola
    }

    @Override
    public boolean isEmpty() {
        return cantidadElementos == 0;
    }

    @Override
    public boolean isFull() {
        return cantidadElementos == capacidad;
    }

    @Override
    public int size() {
        return cantidadElementos;
    }
}

