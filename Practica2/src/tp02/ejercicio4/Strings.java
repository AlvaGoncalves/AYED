package tp02.ejercicio4;

public class Strings {
	public static void mainStrings() {
		PilaGenerica p = new PilaGenerica();
		
		String str = "{[()]}";
		
		for (int i = 1; i < str.length(); i++){
			//si es de apertura apilo
			p.apilar(str.charAt(i));
			//sino desapilo el ultimo que tengo y veo si es el de apertura de este
				//sino es asi termino
				//si es asi apilo
			//APILO SOLO LOS QUE ABREN
		}
		
		while(!p.esVacia()) {
			p.desapiar();
			
			
			
												 
		}
		
	}
}
