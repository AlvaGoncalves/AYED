package Ejercicico5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] Arreglo = new int[5];
		Arreglo[0] = 0;
		Arreglo[1] = 1;
	    Arreglo[2] = 2;
		Arreglo[3] = 3;
		Arreglo[4] = 4;
		
		//a
		Calculos.a(Arreglo);
		
		//b
		int i;
		for(i = 0; i < Arreglo.length; i++) {
			Calculos.b(Arreglo[i], Arreglo.length);
		}
		
	}

}
