package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
	private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
			
	public void encolar(T dato) {
		datos.agregarFinal(dato);
	}
	
	public T desencolar() {
		T x = datos.elemento(1); //elimino el primer elemento de la cola
		datos.eliminarEn(1);
		
		return x;
	}
	
	public T tope() {
		return datos.elemento(1);
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
	
}