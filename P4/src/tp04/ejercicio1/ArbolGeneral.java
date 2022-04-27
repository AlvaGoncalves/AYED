package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> lis = new ListaEnlazadaGenerica<Integer>();
		preOrden(lis, n, a);
		return lis;
	}
	private void preOrden(ListaEnlazadaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		if((a.getDato() % 2 == 0) && (a.getDato() > n)) {	
			l.agregarFinal(a.getDato());
		}
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		lHijos.comenzar();
		while (!lHijos.fin()) {
			(lHijos.proximo()).preOrden(l,n,a);
		}
	}

	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> lis = new ListaEnlazadaGenerica<Integer>();
		InOrden(lis, n, a);
		return lis;
	}
	private void InOrden(ListaEnlazadaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		
		
		// X
		// [1, 2, 3, 4, 5] -> 1 
				
		// hijo izquierdo (1° hijo) --> si !lHijos.esVacia() -> lHijos.proximo().InOrden() --> listaimpares
				
		// trabajo con el dato raiz 
				
		// hijos derechos (los restantes) --> mientras !lHijos.fin() -> lHijos.proximo().InOrden() --> listaimpares
				
		
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		lHijos.comenzar();									  
		
		if(!lHijos.esVacia()) {		//hijo izquierdo
			lHijos.proximo().InOrden(l, n, a);
		}
		
		if((a.getDato() % 2 == 0) && (a.getDato() > n)) { 
			l.agregarFinal(a.getDato());
		}	
		
		while (!lHijos.fin()) {							  
			(lHijos.proximo()).InOrden(l,n,a);
		}			
	
	}
	
	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n) {
		ListaEnlazadaGenerica<Integer> lis = new ListaEnlazadaGenerica<Integer>();
		postOrden(lis, n, a);
		return lis;
	}
	private void postOrden(ListaEnlazadaGenerica<Integer> l, Integer n, ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
		lHijos.comenzar();
		while (!lHijos.fin()) {
			(lHijos.proximo()).postOrden(l,n,a);
		}
		if((a.getDato() % 2 == 0) && (a.getDato() > n)) {	
			l.agregarFinal(a.getDato());
		}
	}
		
	
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, int n){
		ListaGenerica<Integer> result = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> arbol_aux;
		cola.encolar(this);
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if((a.getDato() % 2 == 0) && (a.getDato() > n)) {	
				result.agregarFinal(a.getDato());
			}
			if (arbol_aux.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = arbol_aux.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
		}
	}
	return result;
	
}	