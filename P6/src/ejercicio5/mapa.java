package ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class mapa {
	private Grafo<String> mapaCiudades;
	
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaEnlazadaGenerica<String>lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String>camino = new ListaEnlazadaGenerica<String>(); //lista que voy a devolver
		boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();//aux que voy a recorrer para no tocar ninguna de las otras dos listas
		aux.comenzar();
		Vertice<String> vertice;
		boolean ok = false;
		int i = -1;//inicializo en -1 pq es una posicion
		while((!aux.fin())&(!ok)) {//mientras no encuente la 1er ciudad, y no llegue al final de la lista
			vertice = aux.proximo();//actualizo vertice
			if(vertice.dato() == ciudad1) {
				ok = true;
				i = vertice.getPosicion();
				lis.agregarFinal(vertice.dato());
			}
		}
		if(i != -1) {//si encontre la 1er ciudad hago el dfs, sino retorno
			this.dfs(lis, camino,ciudad2, marca, i);
		}
		return camino;
	}
	
	private void dfs(ListaEnlazadaGenerica<String>lis, ListaEnlazadaGenerica<String> camino,String ciudad2, boolean[] marca, int i) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if(v.dato() == ciudad2) {//si encontre la ciudad2 termine el recorrido
			clonar(lis,camino);
		}
		if(camino.esVacia()) {
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while((!ady.fin())&(camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if(!marca[i]) {
					lis.agregarFinal(destino.dato());
					this.dfs(lis, camino, ciudad2, marca, j);
					lis.eliminarEn(lis.tamanio());
				}
			}
		}
	}
	//copio lis en camino
	private void clonar (ListaEnlazadaGenerica<String> lis,ListaEnlazadaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()+1]; 
		if(!ciudades.incluye(ciudad1)&(!ciudades.incluye(ciudad2))) {
			ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
			aux.comenzar();
			Vertice<String> vertice;
			int i = -1;
			boolean ok = false;
			while(!aux.fin()&&(!ok)) {
				vertice = aux.proximo();
				if(vertice.dato() == ciudad1) {
					ok = true;
					i = vertice.getPosicion();
					lis.agregarFinal(vertice.dato());
				}
			}
			if(i != 1) {
				dfsExceptuando(i, lis, camino, marca, ciudad2, ciudades);
			}
		}
		return camino;
	}
	private void dfsExceptuando(int i, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino, boolean[] marca, String ciudad2, ListaGenerica<String> ciudades) {
		marca[i] = true;
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
		if (v.dato() == ciudad2) {
			clonar (lis,camino);
		}
		if (camino.esVacia()){
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while ((!ady.fin()) && (camino.esVacia())) {
				Vertice<String> destino = ady.proximo().verticeDestino();
				int j = destino.getPosicion();
				if ((!marca[j]) && (!(ciudades.incluye(destino.dato())))) {
					lis.agregarFinal(destino.dato());
					dfsExceptuando(j,lis,camino,marca,ciudad2,ciudades);
					lis.eliminarEn(lis.tamanio());
				}
			}
		}
		
	}
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		int min = 9999;
		boolean [] marca = new boolean [mapaCiudades.listaDeVertices().tamanio()-1];
		ListaEnlazadaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		ListaGenerica<Vertice<String>> aux = mapaCiudades.listaDeVertices();
		boolean ok = false;
		int i = -1;
		while((!aux.fin())&(!ok)) {
			Vertice<String> v = aux.proximo();
			if(v.dato() == ciudad1) {
				ok = true;
				i = v.getPosicion();
				lis.agregarFinal(v.dato());
			}	
		}
		if(i != -1) {	
			int distancia = 0;
			dfsCorto(min, distancia, i, ciudad2, lis, camino, marca);
		}		
		
		return camino;
	}
	
	private void dfsCorto(int distancia, int min, int i, String ciudad2, ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino, boolean[] marca) {
		Vertice<String> vertice = mapaCiudades.listaDeVertices().elemento(i);
		if(vertice.dato() == ciudad2) {
			if(min > distancia) {
				clonar2(lis, camino);//si encunetro un camino menor borro los que tenia antes
				min = distancia;
			}
		}
		else {
			marca[i] = true;//no marco el destino pq voy a volver a ir ahi
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vertice);		
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = vertice.getPosicion();
				if(!marca[j]) {			//pregunto por camino.esvacia()?
					distancia += arista.peso();
					lis.agregarFinal(arista.verticeDestino().dato());
					dfsCorto(distancia, min, i, ciudad2, lis, camino, marca);
					lis.eliminarEn(lis.tamanio());
					distancia -= arista.peso();
				}	
			}
		}	
	}
	
	
	public void clonar2(ListaEnlazadaGenerica<String> lis, ListaEnlazadaGenerica<String> camino) {
		camino.comenzar();
		while(!camino.fin()) {
			camino.eliminar(camino.proximo());
		}
		
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
