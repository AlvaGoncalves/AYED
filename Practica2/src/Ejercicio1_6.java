import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Ejercicio1_6 {
	ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
	
	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		if(n > 1) {	
			if(n % 2 == 0) {
				n = n / 2;
			}else {
				n = 3 * n + 1;
			}
			lista.agregarFinal(n);
			
			calcularSucesion(n);
		}	
			
		return lista;
	}
	
	
}
