import java.util.*;

public class TablasHash {
	int tamanio;
	int[] array = new int[tamanio];

	public TablasHash(int tamaño, int[] array) {
		super();
		this.tamanio = tamaño;
		this.array = array;
	}
//FUNCIONES HASH
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	public int hashLineal(int dni) {
		System.out.println("dni " + dni + " modulo " + tamanio + " = " + (dni % tamanio));
		return dni % tamanio;

	}
	public int hashCuadratico(int dni,int acumulador) {
		System.out.println("dni " + dni + " modulo " + tamanio + " = " + (dni % tamanio));
		return dni % tamanio;

	}
	
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	public void insertarLineal() {
		declararVacia(array);
		for (int i = 0; i < (array.length); i++) {
			int valor = (int) Math.floor(Math.random() * 6 + 1);
			System.out.println("Nuevo valor introducido: "+valor);

			exploracionLineal(valor, array, hashLineal(valor));

		}
	}
	public void insertarCuadratico() {
		declararVacia(array);
		for (int i = 0; i < (array.length); i++) {
			
			int valor=(int) Math.floor(Math.random()*6+1);
			System.out.println("Nuevo valor introducido: "+valor);

			exploracionCuadratica(valor,array,hashLineal(valor), 1);
			
		}
	}
//EXPLORACIONES 
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	public void exploracionLineal(int valor, int[] array, int modulo) {

		// Introducimos el valor

		System.out.println("MODULO RESULTANTE" + (modulo));
		// Acomodamos el valor
		if (modulo < tamanio && array[modulo] == 0) {
			array[modulo] = valor;
			System.out.println("LISTA 01:" + Arrays.toString(array));
			System.out.println("El elemento se ha insertado correctamente.");
		}

		else {

			System.out.println("Hubo colicion, insertado en la posicion siguiente");
			// verificamos cuantos valores ya han tomado esa posicion.
			System.out.println("LISTA 02:" + Arrays.toString(array));
			// System.out.println("MODULO CAMBIADO"+(modulo+1));
			exploracionLineal(valor, array, (hashLineal(modulo+1) ));

		}

		System.out.println("LISTA FINAL:" + Arrays.toString(array));

		// reseteo el false

	}

	public void exploracionCuadratica(int valor, int[] array, int modulo,int contador) {

		// Introducimos el valor

		System.out.println("MODULO RESULTANTE: " + (modulo));
		// Acomodamos el valor
		
			if(modulo < tamanio && array[modulo] == 0) {
				array[modulo] = valor;
				System.out.println("LISTA 01:" + Arrays.toString(array));
				System.out.println("El elemento se ha insertado correctamente.");
				
			}
			else {
				System.out.println("\nCalculando modulo potencia: "+contador+"a la "+29);
				 exploracionCuadratica(valor, array, (int) (hashLineal((int) (modulo+Math.pow(contador, 2)))),(int) (hashLineal((int) (modulo+Math.pow(contador, 2)))));
				
			}
			
			
			
	

	
		
	}
//FUNCION AUXILIAR
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	// Opcion es poner todos los valores del array a 0.
	public void declararVacia(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pongo mi lista vacia.

		int[] array = new int[5];

		TablasHash hash = new TablasHash((array.length), array);
		//lo que ocurre es que cada vez hay menos numeros para poder meter el valor por lo tanto el bucle tiene
		//que iterar bastantes veces hasta encontrar el valor, sin embargo hay un momento que no me contempla el valor.
		hash.insertarLineal();
	//hash.insertarCuadratico();
	}

}
