package parcial;

import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class parcialCiudades {
	
	
	public int resolver(Grafo<City> ciudades, String origen, String destino, int maxControles) {
		boolean [] marca = new boolean[ciudades.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<City>> aux = ciudades.listaDeVertices();
		Max maximo = new Max();
		boolean ok = false;
		int contador = 0;
		Vertice<City> vertice;
		int i = -1;
		aux.comenzar();
		while((!aux.fin())&(!ok)) {
			vertice = aux.proximo();
			if(vertice.dato().getNom().equals(origen)) {
				ok = true;
				i = vertice.getPosicion();
				contador = vertice.dato().getEstadia();
			}	
		}
		if(i != 1) {
			marca[i] = true;
			this.dfs(marca, maximo, i, destino, ciudades, maxControles, contador);
		}
		
		return maximo.getMax();
	}
	
	
	private void dfs(boolean[] marca, Max maximo,int i, String destino, Grafo<City> ciudades, int maxControles, int contador) {
		Vertice<City> v = ciudades.vetice(i);		
		
		if(v.dato().getNom().equals(destino)) {
			if(contador > maximo.getMax()) {
				maximo.setMax(contador);
			}
		}else {
			ListaGenerica<Arista<City>> ady = ciudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<City> a = ady.proximo();
				int j = a.verticeDestino().getPosicion();
				if(!marca[j]) {
					marca[j] = true;
					if(a.peso() <= maxControles) {
						this.dfs(marca, maximo, j, destino, ciudades, maxControles, contador + a.verticeDestino().dato().getEstadia());
					}
					marca[j] = false;
				}
				
			}
		}
		
	}
}
