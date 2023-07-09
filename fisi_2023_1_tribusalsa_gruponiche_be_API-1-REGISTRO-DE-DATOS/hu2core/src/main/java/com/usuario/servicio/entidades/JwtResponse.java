package com.usuario.servicio.entidades;

public class JwtResponse {
	private String token;
	private Usuario usuario;
	private int estado;
	
	public JwtResponse() {
		
	}

	public JwtResponse(String token,Usuario usuario,int estado) {
		super();
		this.token = token;
		this.usuario=usuario;
		this.estado=estado;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
