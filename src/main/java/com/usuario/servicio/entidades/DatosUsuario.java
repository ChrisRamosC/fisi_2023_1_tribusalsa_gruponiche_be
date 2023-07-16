package com.usuario.servicio.entidades;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="datos_usuario" )
public class DatosUsuario {
	@Id
	private int idDatos_usuario;
	
	
	@NotNull(message="La edad es obligatoria")
	private int edad;
	

	@NotNull(message="El sexo es obligatorio")
	private char sexo;
	
	
	@NotNull(message="El peso es obligatorio")
	private float peso;
	
	
	@NotNull(message="La talla es obligatoria")
	private float talla;
	
	
	@NotBlank(message="El nivel_actividad es obligatorio")
	@Pattern(regexp = "sedentario|actividad ligera|moderadamente activa|muy activa",message="nivel de actividad no válido")
	private String nivel_actividad;
	
	
	@NotBlank(message="La zona objetivo es obligatorio")
	@Pattern(regexp = "todo el cuerpo|brazo|pecho|abdominales|piernas|glúteos",message="zona objetivo no válido")
	private String zona_objetivo;
	
	
	@NotBlank(message="El objetivo es obligatorio")
	@Pattern(regexp = "perder peso|aumentar músculo|mantenerme en forma",message="objetivo no válido")
	private String objetivo;
	

	@NotNull(message="El codigo de usuario es obligatorio")
	private int codigo_usuario;
	
    //@ManyToOne
 //   @JoinColumn(name="usuario_codigo" , nullable = false)
   // @OnDelete(action = OnDeleteAction.CASCADE)
	//private Usuario usuario;
	
	public DatosUsuario(){
		
	}
	
	public DatosUsuario(int edad, char sexo, float peso, float talla, String nivel_actividad, String zona_objetivo,
			String objetivo, int codigo_usuario) {
		super();
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.talla = talla;
		this.nivel_actividad = nivel_actividad;
		this.zona_objetivo = zona_objetivo;
		this.objetivo = objetivo;
	
		this.codigo_usuario = codigo_usuario;
	}

	public int getIdDatos_usuario() {
		return idDatos_usuario;
	}

	public void setIdDatos_usuario(int idDatos_usuario) {
		this.idDatos_usuario = idDatos_usuario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getTalla() {
		return talla;
	}

	public void setTalla(float talla) {
		this.talla = talla;
	}

	public String getNivel_actividad() {
		return nivel_actividad;
	}

	public void setNivel_actividad(String nivel_actividad) {
		this.nivel_actividad = nivel_actividad;
	}

	public String getZona_objetivo() {
		return zona_objetivo;
	}

	public void setZona_objetivo(String zona_objetivo) {
		this.zona_objetivo = zona_objetivo;
	}
	
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this. objetivo =  objetivo;
	}


	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario =codigo_usuario;
}


	
	
	
}
