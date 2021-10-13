package Encripter;

import java.util.HashMap;

public class TextoDesencriptar {
	private String texto_desencriptado;
	private String texto_encriptado;
	private String clave_desencriptacion;
	
	
	


	public TextoDesencriptar(String texto_encriptado, String clave_desencriptacion) {
		super();
		this.texto_desencriptado = desencriptacion(texto_encriptado,clave_desencriptacion);
		this.texto_encriptado = texto_encriptado;
		this.clave_desencriptacion = clave_desencriptacion;
	}





	@Override
	public String toString() {
		return "TextoDesencriptar [texto_desencriptado=" + texto_desencriptado + "\n texto_encriptado="
				+ texto_encriptado + "\n clave_desencriptacion=" + clave_desencriptacion + "]";
	}





	public static String desencriptacion(String mensaje,String clave) {
		HashMap <String, Integer> tabla_desencriptar = new HashMap<String, Integer>();
		String codigo = clave;
		String mensajeencriptado = mensaje;
		String mensajeconnumeros="";
		String mensajedesencriptado="";
		String caracter;
		String [] splitcodigo = codigo.split(";");
		for(int x= 0; x<splitcodigo.length ; x++) {
			tabla_desencriptar.put(splitcodigo[x].substring(2,3), Integer.parseInt(splitcodigo[x].substring(0,1)));
		}
		
		
		for(int y = 0; y<mensajeencriptado.length();y++) {
			
			caracter = mensajeencriptado.substring(y,y+1);
			if(caracter.equals("-")) {
				mensajeconnumeros = mensajeconnumeros + "-";
			}
			if(tabla_desencriptar.containsKey(caracter)) {
				mensajeconnumeros = mensajeconnumeros + tabla_desencriptar.get(caracter);
			}
		}
		
		String [] msgconnumeros = mensajeconnumeros.split("-");
		for(int z=0;z<msgconnumeros.length;z++) {
			int numero = Integer.parseInt(msgconnumeros[z]);
			mensajedesencriptado = mensajedesencriptado + (char) (numero);
		}
		
		return mensajedesencriptado;
	}
	
	
	
	
	
}
