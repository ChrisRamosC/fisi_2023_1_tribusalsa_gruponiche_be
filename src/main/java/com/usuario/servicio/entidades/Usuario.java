package com.usuario.servicio.entidades;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@NotBlank(message="El nombre es obligatorio")
	private String nombre;
	
	@NotBlank(message="El telefono es obligatorio")
	private String telefono;
	
	@NotBlank(message="El correo es obligatorio")
	@Email(message="Formato de correo no valido")
	private String correo;
	
	@NotBlank(message="La contraseña es obligatoria")
	private String contrasena;
	
	
	private boolean es_Premium;
	
	
	private boolean es_autenticado;
	
	private String codigo_verificacion;
	
	private LocalDateTime expiracion_codigo;

	
	
	 @Lob
	  private byte[] imagen;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="codigo")
	private List<DatosUsuario> datosUsuariosList;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String telefono, String correo, String contrasena) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isEs_Premium() {
		return es_Premium;
	}

	public void setEs_Premium(boolean es_Premium) {
		this.es_Premium = es_Premium;
	}

	public boolean isEs_autenticado() {
		return es_autenticado;
	}

	public void setEs_autenticado(boolean es_autenticado) {
		this.es_autenticado = es_autenticado;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getCodigo_verificacion() {
		return codigo_verificacion;
	}

	public void setCodigo_verificacion(String codigo_verificacion) {
		this.codigo_verificacion = codigo_verificacion;
	}

	public LocalDateTime getExpiracion_codigo() {
		return expiracion_codigo;
	}

	public void setExpiracion_codigo(LocalDateTime expiracion_codigo) {
		this.expiracion_codigo = expiracion_codigo;
	}
	
	

	
	
	
	
	
}
