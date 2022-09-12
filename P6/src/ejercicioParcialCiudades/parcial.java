package ejercicioParcialCiudades;
/*	Dado un Grafo orientado y valorado positivamente, como por ejemplo el que muestra la
	figura, implemente un método que retorne una lista con todos los caminos cuyo costo
	total sea igual a 10. Se considera costo total del camino a la suma de los costos de las
	aristas que forman parte del camino, desde un vértice origen a un vértice destino.
	
	Se recomienda implementar un método público que invoque a un método recursivo
	privado.
*/

import tp02.ejercicio2.*;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class parcial {
	private Grafo<String> grafo;
	
	public ListaGenerica<ListaGenerica<Vertice<String>>> reorridoIgualDiez(Grafo<String> grafo){
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<String>> lis = null; //lista donde voy a llevar el camino actual
		ListaGenerica<ListaGenerica<Vertice<String>>> caminos = new ListaEnlazadaGenerica<ListaGenerica<Vertice<String>>>(); //lista a devolver
		int costo = 0;
		for(int i = 0; i <= grafo.listaDeVertices().tamanio(); i++) {//me muevo en todos los vertices del grafo, porque cualquier vertice puede ser uno de partida
			lis = new ListaEnlazadaGenerica<Vertice<String>>(); //donde voy a llevar el camino act
			lis.agregarFinal(grafo.listaDeVertices().elemento(costo));//Tomo el primer vertice desde el que voy a recorrer todo
			marca[i] = true;
			this.dfs(i, marca, lis, caminos, costo, grafo);
			marca[i] = false; //saco la marca por si no es ese el camino = 10
		}
		return caminos;
	}
	
	private void dfs(int i, boolean[] marca, ListaEnlazadaGenerica<Vertice<String>> lis, ListaGenerica<ListaGenerica<Vertice<String>>> caminos, int costo, Grafo<String> grafo) {
		Vertice<String> vDestino = null;
		int p = 0, j =0;
		Vertice<String> vPartida = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vPartida);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<String> a = ady.proximo();//tomo la arista que conecta con dest 
			j = a.verticeDestino().getPosicion(); //recupero la pos del vertice destino
			if(!marca[j]) { //si el vertice destino no fue marcado
				p = a.peso();
				if((costo+p) <= 10) {
					vDestino = a.verticeDestino();//tomo el valor visitado
					lis.agregarFinal(vDestino);//lo agrego a la lista
					marca[j] = true;//lo marco como visitado
					if((costo+p) == 10) //si el costo act + el peso de la lista es = a 10
						caminos.agregarFinal(lis.clonar()); //hago una copia de la lista con el camino actual //deberia ser lis.copia() no clonar
					else	
						this.dfs(i, marca, lis, caminos, costo+p, grafo);//si no es igual a 10(es menor), sigo analizando el camino
					//backtracking
					lis.eliminar(vDestino);//al terminar el recorrido saco el vertice destino porque puede ser que haya otro camino que pase por ese vertice
					marca[j] = false;//por lo que tamb le quito la marca
					}
				
			}	
		}
	}
}
