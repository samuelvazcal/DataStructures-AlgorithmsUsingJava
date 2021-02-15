package com.samuelvazquez;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("Tabla del 7");
		multiplicar(7,10);
	}

	public static void multiplicar(int iTabla, int iNumero){
		if (iNumero>1){
			multiplicar(iTabla,iNumero-1);
		}
		System.out.println(iTabla + "x" + iNumero + "=" + iTabla*iNumero);
	}
}
