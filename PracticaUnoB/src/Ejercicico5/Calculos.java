package Ejercicico5;

public class Calculos {
	//c
	static public int diml = 3;
	static public int ArregloC[];
	
	public void CargarC() {
		int i;
		for (i = 0; i < diml; i++) {
			int x = 2;
			ArregloC[i] = x++;
			
			x++;
		}
	}

	
	public static int[] a(int Arreglo[]) {
		int [] retorno = new int[3];
		
		int tot = 0;
		int max = 0;
		int min = 9999;
		int p, i;
		
		for (i=0; i<Arreglo.length; i++) {
			if(max < Arreglo[i]) {
				max = Arreglo[i];
			}
			if(min > Arreglo[i]) {
				min = Arreglo[i];
			}
			tot = tot + Arreglo[i];
		}
		p = tot / Arreglo.length;
		
		retorno[0] = max;
		retorno[1] = min;
		retorno[2] = p;
		
		return retorno;
	}
	
	public static int[] b(int dato, int largo) {
		int [] retorno = new int[3];
		
		int tot = 0;
		int max = 0;
		int min = 9999;
		int p;
		
		if(max < dato) {
			max = dato;
		}
		if(min > dato) {
			min = dato;
		}
		tot = tot + dato;
		p = tot / largo;
		
		retorno[0] = max;
		retorno[1] = min;
		retorno[2] = p;
		
		return retorno;
	}
	
	public void c() {
		int tot = 0;
		int max = 0;
		int min = 9999;
		int p, i;
		
		for (i=0; i < diml; i++) {
			if(max < ArregloC[i]) {
				max = ArregloC[i];
			}
			if(min > ArregloC[i]) {
				min = ArregloC[i];
			}
			tot = tot + ArregloC[i];
		}
		p = tot / ArregloC.length;
		
		System.out.println(min);
		System.out.println(max);
		System.out.println(tot);
		
	}
	
}