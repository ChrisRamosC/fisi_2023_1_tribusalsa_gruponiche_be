package com.usuario.servicio.repositorio;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.usuario.servicio.entidades.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Integer>{
	public Optional<Usuario> findByCodigo(int codigo);
	public Optional<Usuario> findByCorreo(String correo);
	@Query("SELECT u FROM Usuario u WHERE u.codigo_verificacion = :codigo_verificacion AND u.expiracion_codigo > CURRENT_TIMESTAMP")
	public Usuario findByCodigo_verificacion(@Param("codigo_verificacion") String codigo_verificacion);
}
