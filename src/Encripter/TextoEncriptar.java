package Encripter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextoEncriptar {
	private static HashMap <Integer, String> clave_codificacion = new HashMap<Integer, String>();
	private static String mensaje;
	private static String cadena_clave;
	private static String mensaje_encriptado;
	
	
	
	
	
	
	public TextoEncriptar(String mensaje) {
		super();
		this.cadena_clave = Clave();
		this.mensaje_encriptado = EncriptarMensaje(mensaje);
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "Texto Encriptado\n  Mensaje Original=" + mensaje + "\n  Mensaje encriptado=" + mensaje_encriptado + "\n Clave para descodificar=\n\t"+cadena_clave;
	}
	
	
	//Encriptación
	public static String EncriptarMensaje(String mensaje) {
		// Mensaje a bytes
		String nuevo_mensaje = mensaje;
		
		byte[] textobyte = nuevo_mensaje.getBytes();
		// Transformar bytes en int
		ArrayList lista_numeros_convert = new ArrayList();
		for (int i = 0; i < textobyte.length; i++) {
			if (i != (textobyte.length - 1)) {
				lista_numeros_convert.add(textobyte[i]);
				lista_numeros_convert.add("-");
			} else {
				lista_numeros_convert.add(textobyte[i]);
			}

		}

		// Intercambio
		String encriptado_mensaje="";
		
		for(int x=0;x < lista_numeros_convert.size();x++) {
			String unoaunochar = lista_numeros_convert.get(x).toString();
			int contar = lista_numeros_convert.get(x).toString().length();
			if(lista_numeros_convert.get(x) != "-") {
				for(int y=0;y<contar;y++) {
					char unoauno = lista_numeros_convert.get(x).toString().charAt(y);
					String unoaunostring = String.valueOf(unoauno);
					int num = Integer.parseInt(unoaunostring);
					unoaunostring = clave_codificacion.get(num);
					encriptado_mensaje = encriptado_mensaje + unoaunostring;
					
				}
			}else {
				encriptado_mensaje = encriptado_mensaje+"-";
			}
			
			
		}
		return encriptado_mensaje;
	}
	
	//Clave
	public static String Clave() 
	{
		
		String clave_cadena ="";
		
		
		char caracteres[] = new char[10];
		caracteres = letraAle() ;
		
		for(int x=0;x<caracteres.length;x++) {
			clave_codificacion.put(x, String.valueOf(caracteres[x]));
		}
		
		for(int x : clave_codificacion.keySet()) {
			if(x != clave_codificacion.size()-1) {
				clave_cadena = clave_cadena +( x+":"+clave_codificacion.get(x))+";";
			}else {
				clave_cadena = clave_cadena +( x+":"+clave_codificacion.get(x));
			}
			
		}
		return clave_cadena ;
	}
	public static char[] letraAle() {
		int numeros[] = new int[10];
		char caracteres[] = new char[10];
		//Para insertar elementos en el array
        for (int i = 0; i < 10; i++) {
            numeros[i] = numerosaleatorios();
        }
        //Cambiar elementos repetidos
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if( i != j){
                    if(numeros[i] == numeros[j]){
                        numeros[i] = numerosaleatorios();
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
        //Trnasformar los elementos
        for(int x =0;x< 10;x++) {
        	caracteres[x] = (char) (numeros[x]+'A');
        }
		
		return caracteres;
	}
	public static int numerosaleatorios(){
        return (int)(Math.random()*26);
    }

}
