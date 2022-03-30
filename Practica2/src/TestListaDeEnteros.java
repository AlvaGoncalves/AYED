
import tp02.ejercicio1.*;

public class TestListaDeEnteros {

	public static void main(String[] args) {
	  ListaDeEnterosConArreglos L = new ListaDeEnterosConArreglos();	
	  
	  for(int i = 0; i < args.length; i++) {
		 Integer x = Integer.parseInt(args[i]);
		 
		 L.agregarFinal(x);
	  }	 
	
	  L.comenzar();
	  while( !L.fin()) {
	  	System.out.println(L.proximo());
	  }	
	}
}
