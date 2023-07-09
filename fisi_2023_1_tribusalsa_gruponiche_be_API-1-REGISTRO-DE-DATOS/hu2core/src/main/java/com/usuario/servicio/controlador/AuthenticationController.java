package com.usuario.servicio.controlador;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.servicio.configuraciones.JwtUtils;
import com.usuario.servicio.entidades.JwtResponse;
import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.servicio.EmailSenderService;
import com.usuario.servicio.servicio.UserDetailsServiceImpl;
import com.usuario.servicio.servicio.UsuarioServiceImpl;
import com.usuario.servicio.utils.MessageDto;
import com.usuario.servicio.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/ux-registrar-datos/fitorfat/servicio-al-cliente/v1/autenticacion")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;	
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@PostMapping("/iniciar-sesion")
	public ResponseEntity<?> generarToken(@RequestParam String correo,@RequestParam String contrasena) throws Exception{
		try {
			autenticar(correo,contrasena);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Usuario no encontrado");
		}
		UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(correo);
		String  token=this.jwtUtils.generateToken(userDetails);
		Optional<Usuario> opUsuario=usuarioService.findByCorreo(correo);
		return ResponseEntity.ok(new JwtResponse(token,opUsuario.get(),HttpStatus.OK.value()));
	}

	
	
	private void autenticar(String correo,String contrasena) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(correo, contrasena));
			
		} catch (DisabledException disabledException) {
			throw new Exception("Usuario Deshabilitado"+disabledException.getMessage());
		} catch(BadCredentialsException badCredentialsException) {
			throw new Exception("Creedenciales invalidas"+badCredentialsException.getMessage());
		}
	}
	
}
