import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Main1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio1_6 f = new Ejercicio1_6();
		
		ListaDeEnterosEnlazada l = f.calcularSucesion(6);
		l.comenzar();
		
		while(!l.fin()) {	
			System.out.println(l.proximo());
			
		}
	}

}
