package Ejercicio2;

import java.util.Scanner;

public class GeneraArreglo {
	
	public static int[] devolverArreglo (){
		Scanner s = new Scanner (System.in);
		System.out.println("Ingrese numero: ");
		int n;
		n = s.nextInt();
		int aMultiplos[]=new int [n];
		int aux=1;
		for (int i=0;i<n;i++) {
			aMultiplos[i]=n*aux;	
			aux++;
		}
		s.close();
		return aMultiplos;
	}
}
