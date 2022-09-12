package ejercicio4;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class recorridos<T> {

	public ListaGenerica<Vertice<T>> Dfs (Grafo<T> grafo){
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()-1];					//guardo las marcas de visitado en un vector de boolean
		ListaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();				//lista que voy a devolver
		for(int i = 0; i <= grafo.listaDeVertices().tamanio(); i++) {							//voy recorriendo los vertices
			if(!marca[i]) {																		//si no lo visite
				dfs(grafo, i, lis, marca);													    //llamo recursivamente al dfs
			}
				
		}
		
		return lis;
	}
	
	private void dfs(Grafo<T> grafo, int i, ListaGenerica<Vertice<T>> lis, boolean[] marca) {
		marca[i] = true;																		//marco el vertice como visitado
		Vertice<T> v = grafo.listaDeVertices().elemento(i);										//tomo el valor del elemento
		lis.agregarEn(v,lis.tamanio());															//lo agrego a la lista que voy a devolver
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);								//tomo la lista de adyacentes
		ady.comenzar();
		while(!ady.fin()) {                                                                     //me muevo por los ady de v hasta marcar todos
			int j = ady.proximo().verticeDestino().getPosicion();								//tomo la posicion del vertice destino de la lista actual que estoy procesando
			if(!marca[j]) {																		//si ese vertice que tome no esta marcado, vuelvo a hacer la recursion
				this.dfs(grafo, j, lis, marca);
			}
		}
	}
	
	public ListaGenerica<Vertice<T>> Bfs(Grafo<T> grafo){
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()-1];
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for(int i = 0; i <= grafo.listaDeVertices().tamanio(); i++) {
			if(!marca[i]) {
				bfs(grafo, lis, i, marca);
			}
		}
		return lis;
	}
	
	private void bfs(Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lis, int i, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();		//cola para el orden en el que vamos a procesar los vertices
		cola.encolar(grafo.listaDeVertices().elemento(i));					//encolo el 1er vertice
		marca[i] = true;
		while(!cola.esVacia()) {
			Vertice<T> v = cola.desencolar();
			lis.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);								
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> a = ady.proximo();
				int j = a.verticeDestino().getPosicion();					//tomo la pos del vertice de la lista de ady
				if(!marca[j]) {												//si no esta marcado
					Vertice<T> w = a.verticeDestino();						//tomo el vertice por medio de la arista
					marca[j] = true;										//marco el vertice
					cola.encolar(w);										//lo encolo
				}
			}
		}
		
	}
}
