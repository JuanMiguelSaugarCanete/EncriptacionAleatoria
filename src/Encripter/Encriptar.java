package Encripter;

import java.util.Scanner;

public class Encriptar {

	public static void main(String[] args) {
		Scanner escaner = new Scanner(System.in);
		String opcion;
		
		System.out.println("Dinos que quieres hacer: \n 1-Encriptar \n 2-Desencriptar");
		opcion= escaner.nextLine();
		if(opcion.equals("1")) {
			System.out.println("¿Que quieres encriptar?");
			String mensaje_encriptar = escaner.nextLine();
			TextoEncriptar encriptacion = new TextoEncriptar(mensaje_encriptar);
			System.out.println(encriptacion.toString());
			
		}
		if(opcion.equals("2")) {
			String clave;
			String mensajeencriptado;
			System.out.println("Pon la clave");
			clave = escaner.nextLine();
			System.out.println("Pon el mensaje encriptado");
			mensajeencriptado = escaner.nextLine();
			TextoDesencriptar desencriptacion = new TextoDesencriptar(mensajeencriptado, clave);
			System.out.println(desencriptacion.toString());
			
		}else {
			System.out.println("opción no válida");
		}
		
		
		

	}
	

}
