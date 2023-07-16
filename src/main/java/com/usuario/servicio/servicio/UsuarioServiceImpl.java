package com.usuario.servicio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.repositorio.UsuarioRepository;
import com.usuario.servicio.utils.AttributeException;
import com.usuario.servicio.utils.ResourceNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> getAll() throws ResourceNotFoundException {
		List<Usuario> usuarios=usuarioRepository.findAll();
		if(usuarios.isEmpty()) {
			throw new ResourceNotFoundException("No hay usuarios en el sistema");
		}
		return usuarioRepository.findAll();
	}
	@Override
	@Transactional
	public Usuario save(Usuario usuario) throws AttributeException {
		Usuario nuevoUsuario= usuarioRepository.save(usuario);
		return nuevoUsuario;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(int codigo){
		return usuarioRepository.findByCodigo(codigo);
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByCorreo(correo);
	}
	@Override
	public Usuario findByCodigo_verificacion(String codigo_verificacion) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByCodigo_verificacion(codigo_verificacion);
	}
	
	
}
