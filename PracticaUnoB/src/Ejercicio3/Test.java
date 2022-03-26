package Ejercicio3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estudiante e1 = new Estudiante();

		e1.setNombre("Juan");
		e1.setApellido("Gomez");
		e1.setDireccion("la plata");
		e1.setEmail("juansitoxd@hotmail.com");
		e1.setComision("comision 1");
		
		Estudiante e2 = new Estudiante();
		
		e2.setNombre("Pedro");
		e2.setApellido("Gonzalez");
		e2.setDireccion("moron");
		e2.setEmail("PedritoRockstar@hotmail.com");
		e2.setComision("comision 2");
		
		//Carga de los profesores
		
		Profesor p1 = new Profesor();
		
		p1.setNombre("Mariano");
		p1.setApellido("Bilos");
		p1.setEmail("Tupeladito@hotmail.com");
		p1.setCatedra("Biologia 1");
		p1.setFacultad("Medicina UNLP");
		
		Profesor p2 = new Profesor();
		
		p2.setNombre("Oscar");
		p2.setApellido("Magdalena");
		p2.setEmail("OscarM@hotmail.com");
		p2.setCatedra("Cadp");
		p2.setFacultad("Informatica UNLP");
		
		Profesor p3 = new Profesor();
		
		p3.setNombre("Mirtha");
		p3.setApellido("Fragatti");
		p3.setEmail("MirthaGamer@hotmail.com");
		p3.setCatedra("Quimica 3");
		p3.setFacultad("Medicina UNLP");
		
		//Temino la carga de info
		//Inicio con los arreglos
											   //0 1 2
		Profesor[] ArregloP = new Profesor[3]; //[][][]
		
		Estudiante[] ArregloE = new Estudiante[2];
		
		ArregloP[0] = p1;
		ArregloP[1] = p2;
		ArregloP[2] = p3;
		
		ArregloE[0] = e1;
	    ArregloE[1]	= e2;
	
	    int i, j;
	    for (i=0;i < 3; i++) {
	    	System.out.println(ArregloP[i].tusDatos());
	    }
	    for (j=0;j < 2; j++) {
	    	System.out.println(ArregloE[j].tusDatos());
	    }
		
	}

}











