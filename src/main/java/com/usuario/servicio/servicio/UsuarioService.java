package com.usuario.servicio.servicio;

import java.util.List;
import java.util.Optional;

import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.utils.AttributeException;

public interface UsuarioService {
	public List<Usuario> getAll() throws Exception;
	public Usuario save(Usuario usuario) throws AttributeException;
	public Optional<Usuario> findById(int codigo);
	public Optional<Usuario> findByCorreo(String correo);
	public Usuario findByCodigo_verificacion( String codigo_verificacion);
}
