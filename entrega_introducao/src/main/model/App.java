package model;


import org.apache.commons.text.WordUtils;



public class App {
	public static void main(String[] args) {
		System.out.println(WordUtils.capitalize("hello world"));
		System.out.println(WordUtils.capitalize("stephanie"));

	}
	public String capitalLetter(String text){
		String letraMaiuscula = text;
		String resultado = WordUtils.capitalize(letraMaiuscula);
		return resultado;
	}
	
}
