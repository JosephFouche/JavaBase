package com.mycompany.eduardomartineztp4.cajeroautomatico;

import Excepciones.ColaLlenaException;
import Excepciones.ColaVaciaException;
/*
// Define una interface que deben implementar todos los que crean una
// EDatos est�tica tipo Cola utilizando datos gen�ricos como elementos
*/
public interface InterfaceColaEstatica <T>{

  	//crea la cola con la cantidad de elementos recibido como par�metro
	public void iniciar(int cantElementos);

	//insertar el elemento
	public void insertar(T elemento) throws ColaLlenaException;
	
	//quitar el elemento de la cola
	public T atender() throws ColaVaciaException;
	
	//devuelve el elemento pr�ximo a ser atendido
	public T consultar() throws ColaVaciaException;

	//devuelve la posicion del dato en la cola, siendo 1 el dato que esta
    //en el frente de la cola y 0 si no encuentra
	public int buscar(T dato);

	//devuelve true si esta vac�a la estructura
	public boolean isEmpty();

	//devuelve true si esta llena la estructura
	public boolean isFull();

	//devuelve la cantidad de elementos cargados en la cola
	public int size();
}
