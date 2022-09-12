package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
	private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T dato) {
		datos.agregarInicio(dato);
	}
	
	public T desapilar() {
		T eliminado = datos.elemento(1);
		datos.eliminarEn(1);
		
		return eliminado;
	}
	
	public T tope() {
		return datos.elemento(1); 
	}
	
	public boolean esVacia() {
		return datos.tamanio() == 0;
	}
}
