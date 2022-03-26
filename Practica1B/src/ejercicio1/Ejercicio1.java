package ejercicio1;

public class Ejercicio1 {
	public static void utilizFor(int a, int b){
		int max;
		if (a>b){
			max=a;
			a=b;
			b=max;
		}
		
		for(int i=a; i<=b; i++){
			System.out.println(i);
		}
		
	}
	
	public static void utilizWhile(int a, int b){
		int max;
		if (a>b){
			max=a;
			a=b;
			b=max;
		}
		while (a<=b){
			System.out.println(a++);
		}
	}
	
	private static void recOculta(int a, int b){
		
		if(a>b){
			System.out.println("Fin");
		}
		else{
			System.out.println(a);
			a++;
			recOculta(a,b);
			
				
			}
			
		}
	/*----------------------------------------------*/
	
	public static void recursion(int a, int b){
		int max;
		if (a>b){
			max=a;
			a=b;
			b=max;
		}
		recOculta(a,b);
		
	}
	/*---------------------------------------------*/
	
	public static void main(String[] args){
		int a=20;
		int b=10;
		
		
		System.out.println("Utilizando For");
		utilizFor(a,b);
		System.out.println("Utilizando While");
		utilizWhile(a, b);
		System.out.println("Utilizando Recursion");
		recursion(a,b);
	}
}