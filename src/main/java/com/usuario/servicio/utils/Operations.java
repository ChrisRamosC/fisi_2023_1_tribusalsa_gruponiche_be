package com.usuario.servicio.utils;

public class Operations {
	public static String trimBrackets(String message) {
		return message.replaceAll("[\\[\\]]","");
	}
}
