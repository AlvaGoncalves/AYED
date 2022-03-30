import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {

	public static void inverso(ListaDeEnterosEnlazada L) {
		if(!L.fin()) {
			int x = L.proximo();
			System.out.println(x);
			inverso(L);
			
		}		
		System.out.println('x');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosEnlazada L = new ListaDeEnterosEnlazada();

		for (int i = 0; i < args.length; i++) {
			Integer x = Integer.parseInt(args[i]);

			L.agregarFinal(x);
		}
		
		L.comenzar();
		inverso(L);
		while (!L.fin()) {
			System.out.println(L.proximo());
		}
	}
}
