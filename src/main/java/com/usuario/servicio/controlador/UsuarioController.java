package com.usuario.servicio.controlador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.servicio.EmailSenderService;
import com.usuario.servicio.servicio.UsuarioService;
import com.usuario.servicio.servicio.UsuarioServiceImpl;
import com.usuario.servicio.utils.AttributeException;
import com.usuario.servicio.utils.MessageDto;
import com.usuario.servicio.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/ux-registrar-datos/fitorfat/servicio-al-cliente/v1/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioService;	
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@GetMapping("/listar-usuarios")
	public ResponseEntity <?> listarUsuarios () throws ResourceNotFoundException{
		List<Usuario> usuarios=usuarioService.getAll();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/obtener-imagenes/{id}")
	public ResponseEntity <?> obtenerImagen(@PathVariable int codigo) throws ResourceNotFoundException {
	    Usuario usuario = usuarioService.findById(codigo).orElse(null);
	    if (usuario == null) {
	        throw new ResourceNotFoundException("Usuario no encontrado");
	    }
	    if (usuario.getImagen()==null) {
	    	 throw new ResourceNotFoundException("Imagen no encontrada");
	    }
	    return ResponseEntity.ok(usuario.getImagen());
	}
	
	@PostMapping("/registrar-usuarios")
	public ResponseEntity<MessageDto> guardarUsuario(@Valid @RequestBody Usuario usuario) throws AttributeException{
		Optional<Usuario> usuarioOptional=usuarioService.findByCorreo(usuario.getCorreo());
		if(usuarioOptional.isPresent()){
			throw new AttributeException("Ese correo ya esta registrado");
		}
		usuario.setEs_autenticado(false);
		usuario.setEs_Premium(false);
		usuario.setImagen(null);
		usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
		Usuario nuevoUsuario = usuarioService.save(usuario);
		return ResponseEntity.ok(new MessageDto(HttpStatus.CREATED.value(),"Usuario creado con éxito"));
	}
	
	@PostMapping("/solicitar-codigo-recuperacion")
	public ResponseEntity<?> recuperarContrasena(@RequestParam String correo) throws Exception{
		Optional<Usuario> opUsuario=usuarioService.findByCorreo(correo);
		if( !opUsuario.isPresent()) {
			throw new ResourceNotFoundException("Usuario no encontrado");
		}
		 // Genera un código de verificación numérico de 6 dígitos
	    String verificationCode = String.format("%06d", new Random().nextInt(1000000));
	    // Almacena el código de verificación en la base de datos junto con la fecha y hora en la que se generó
	    Usuario usuario = opUsuario.get();
	    usuario.setCodigo_verificacion(verificationCode);
	    usuario.setExpiracion_codigo(LocalDateTime.now().plusMinutes(30));
	   
	        
		 SimpleMailMessage mailMessage = new SimpleMailMessage();
		 mailMessage.setTo(usuario.getCorreo());
		 mailMessage.setSubject("Recupera tu contraseña");
		 mailMessage.setFrom("enanitosverdesG06@gmail.com");
		 mailMessage.setText("tu codigo de verificación es: "+verificationCode);

	            // Send the email
		// Send the email
		 
		 emailSenderService.sendEmail(mailMessage);
		 usuarioService.save(usuario);
			return ResponseEntity.ok(new MessageDto(HttpStatus.ACCEPTED.value(),"Correo enviado"));
	}
	
	@PostMapping("/verificar-codigo-recuperacion")
	public ResponseEntity<?> verificarCodigo(@RequestParam String codigo_verificacion) throws Exception{
		Usuario usuario= usuarioService.findByCodigo_verificacion(codigo_verificacion);
		if (usuario == null) {
			throw new ResourceNotFoundException("Código invalido");
	    }
		return ResponseEntity.ok(new MessageDto(HttpStatus.ACCEPTED.value(),"Codigo válido"));
	}
	
	@PostMapping("/reestablecer-password")
	public ResponseEntity<?> restablecerContrasena(@RequestParam String codigo_verificacion , @RequestParam String contrasena) throws Exception{
		Usuario usuario= usuarioService.findByCodigo_verificacion(codigo_verificacion);
		if (usuario == null) {
			throw new ResourceNotFoundException("Código invalido");
	    }
		usuario.setContrasena(bCryptPasswordEncoder.encode(contrasena));
		usuario.setCodigo_verificacion(null);
		usuario.setExpiracion_codigo(null);
		usuarioService.save(usuario);
		return ResponseEntity.ok(new MessageDto(HttpStatus.ACCEPTED.value(),"Contraseña restablecida"));
	}
	
	@PutMapping("/actualizar-imagenes/{id}")
	public ResponseEntity<?> updateUserImage(@PathVariable int codigo, @RequestBody MultipartFile imagen) throws ResourceNotFoundException, AttributeException {
	    Usuario usuario = usuarioService.findById(codigo).orElse(null);
	    if (usuario == null) {
	        throw new ResourceNotFoundException("Usuario no encontrado");
	    }
	    try {
	        usuario.setImagen(imagen.getBytes());
	        usuarioService.save(usuario);
	        return ResponseEntity.ok(new MessageDto(HttpStatus.ACCEPTED.value(),"Imagen añadida"));
	    } catch (IOException e) {
	        return ResponseEntity.badRequest().build();
	    }
	}
	
	
	
}
