package accesoUsr;

import java.util.Scanner;

public class VistaSesionTexto {

	 Scanner entradaEscaner;
	 
	 
	public VistaSesionTexto(Scanner entradaEscaner) {
		entradaEscaner = new Scanner(System.in);
		this.entradaEscaner = entradaEscaner;
		
	}
	
	public void pedirIdUsr(){
		
		System.out.println("introduce un idUsr: ");
		assert(entradaEscaner.nextLine()!=null);
	
		
	}
	
	public void pedirClaveAcceso(){
		System.out.println("introduce clave de accceso: ");
		assert (entradaEscaner.nextLine()!=null);
		
	}
	 
	public void mostrar(Object obj){
		
		System.out.println(obj.toString());
		
	}
	
	
}
