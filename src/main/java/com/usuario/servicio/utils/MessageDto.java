package com.usuario.servicio.utils;

public class MessageDto {
	private int estado;
	private String mensaje;
	
	public MessageDto() {
		
	}
	public MessageDto(int estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}