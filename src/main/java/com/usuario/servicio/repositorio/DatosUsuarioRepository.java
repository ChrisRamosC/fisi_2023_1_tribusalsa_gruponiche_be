package com.usuario.servicio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.servicio.entidades.DatosUsuario;



@Repository
@Transactional
public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario,Integer>{
	@Modifying
	@Query(value="{call ingresar_datosusuario(:edad, :sexo, :peso, :talla, :nivel_actividad, :zona_objetivo, :objetivo, :usuario_codigo)}",nativeQuery=true)
	 void saveDatosUsuario(
			@Param("edad")int edad,
			@Param("sexo")char sexo,
			@Param("peso")float peso,
			@Param("talla")float talla,
			@Param("nivel_actividad")String nivel_actividad,
			@Param("zona_objetivo")String zona_objetivo,
			@Param("objetivo")String objetivo,
			@Param("usuario_codigo")int usuario_codigo
			
	);
	
	
	
}

