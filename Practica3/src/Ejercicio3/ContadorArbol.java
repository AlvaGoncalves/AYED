package Ejercicio3;

import tp02.ejercicio2.ListaGenerica;

public class ContadorArbol {
	ArbolBinario<Integer> a = new ArbolBinario<Integer>();
	
	public ListaGenerica<Integer> numerosParesInOrden(ArbolBinario<Integer> a, ListaGenerica<Integer> L){
		
		if(this.tieneHijoIzquierdo) {
			numerosParesInOrden(this.getHijoIzquierdo, L);
		}	
		if(a.getDato() % 2 == 0) {
				L.agregarInicio(a.getDato);
		}
		if(a.tieneHijoDerecho) {
				numerosParesInOrden(this.getHijoDerecho, L);
		}
	}
	
	public ListaGenerica<Integer> numerosParesPostOrden(ArbolBinario<Integer> a, ListaGenerica<Integer> L){
		if(this.tieneHijoDerecho) {
			nnumerosParesPostOrden(this.getHijoDerecho, L);
		}
		if(a.getDato() % 2 == 0) {
			L.agregarInicio(a.getDato);
		}
		if(a.tieneHijoIzquierdo) {
			numerosParesPostOrden(this.getHijoIzquierdo, L);
		}
	}
}
