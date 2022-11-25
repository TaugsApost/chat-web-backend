package br.com.taugs.chat.utils;

public class Utils {

	public static String stringLike(String s) {
		String palavra = "";
		if (!(s == null)) {
			palavra = s;
		}
		return "%" + palavra.toUpperCase() + "%";
	}

}
