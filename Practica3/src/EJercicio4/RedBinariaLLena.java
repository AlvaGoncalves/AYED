package EJercicio4;

public class RedBinariaLLena {
	ArbolBinario<Integer> a = new ArbolBinario<Integer>();
	
	int max = -1;
	
	public int reenvio() {
		Integer cont = 0;
		retardoReenvio(this.a, cont);
		return max;
	}
		
	private void retardoReenvio(ArbolBinario<Integer> a2, Integer cont) {
		cont = cont + a2.getDato();
		
		if(!a2.esHoja()) {
			if(a2.tieneHijoIzquierdo()) {
				retardoReenvio(a2.getHijoIzquierdo(), cont);
			}
			if(a2.tieneHijoDerecho()) {
				retardoReenvio(a2.getHijoDerecho(), cont);
			}	
		}
		else {
			if(cont > max) {
				max = cont;
			}
		}
		// return max; //el max lo retorno siempre porque con cada iteracion lo pierdo
	}

}
