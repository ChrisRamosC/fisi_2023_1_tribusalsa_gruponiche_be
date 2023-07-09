package com.usuario.servicio.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.repositorio.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario=this.usuarioRepository.findByCorreo(correo);
		if(!usuario.isPresent()) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return new UserDetailsImpl(usuario.get());
	}

}
