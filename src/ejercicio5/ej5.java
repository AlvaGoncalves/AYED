package ejercicio5;

import ListasGenericas.src.tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class ej5 {
	private Grafo<String> g; 
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		boolean[] marca = new boolean[g.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<String>> lis = new ListaEnlazadaGenerica<Vertice<String>>();
		for(int i=1; i<=g.listaDeVertices().tamanio();i++){
			if (!marca[i])
				this.dfs(i, g, lis, marca);
		}
		return lis;
	}
	
	private ListaGenerica<Vertice<String>> dfs(int i, Grafo<String> g, ListaGenerica<Vertice<String>> lis, boolean[] marca) {
		marca[i] = true;
		
	}
}
