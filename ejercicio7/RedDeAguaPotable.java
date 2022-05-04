package ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable<x> {
	private ArbolGeneral<x> a;
	
	public RedDeAguaPotable(ArbolGeneral a){
		this.a = a;
	}
	
	public double minimoCaudal(double caudal) {
		ResultadoCaudal rc = new ResultadoCaudal();
		rc.min = caudal;
		
		calculoEquitativo(a, caudal, rc);
		
		return rc.min;
	}
	private void calculoEquitativo(ArbolGeneral a, double c, ResultadoCaudal rc) {
		ListaEnlazadaGenerica<ArbolGeneral<x>> lhijos = new ListaEnlazadaGenerica<ArbolGeneral<x>>();
		if(a.tieneHijos()) {			
			lhijos.comenzar();
			while(!lhijos.fin()) {
				// llamo recursivamente con cada hijo y caudal bifurcado (caudal/cantidad hijos)
				calculoEquitativo(lhijos.proximo(), c/lhijos.tamanio(), rc);
			}
		}
		else {
			if(c > rc.min) {
				rc.min = c;
			}
			
		}
	}	
//  resultadoCaudal.minimo = caudal  --> resultadoCaudal (ResultadoCaudal public Integer minimo)
}
