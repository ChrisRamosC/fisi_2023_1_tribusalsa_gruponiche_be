package com.usuario.servicio.controlador;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.servicio.entidades.DatosUsuario;
import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.servicio.DatosUsuarioServiceImpl;
import com.usuario.servicio.servicio.UsuarioServiceImpl;
import com.usuario.servicio.utils.AttributeException;
import com.usuario.servicio.utils.MessageDto;
import com.usuario.servicio.utils.ResourceNotFoundException;

@RestController
@RequestMapping("/ux-registrar-datos/fitorfat/servicio-al-cliente/v1/detalles-usuario")
public class DatosUsuarioController {
	
	@Autowired
	private DatosUsuarioServiceImpl datosUsuarioService;	
	@Autowired
	private UsuarioServiceImpl usuarioService;	
	@PostMapping("/registrar-detalles-usuarios/{id}")
	public ResponseEntity<MessageDto> guardarDatos(@PathVariable int id ,@Valid @RequestBody DatosUsuario datosUsuario) throws  AttributeException, ResourceNotFoundException{
		Optional<Usuario> opUsuario=usuarioService.findById(id);
		if(opUsuario.isPresent()) {
			datosUsuario.setCodigo_usuario(id);
			datosUsuarioService.saveDatosUsuario(datosUsuario);
			return ResponseEntity.ok(new MessageDto(HttpStatus.OK.value(),"Se registro los datos del usuario con éxito"));
		}else {
			throw new ResourceNotFoundException("Usuario no encontrado");
		}	
	}
	
	@PutMapping("/actualizar-detalles-usuarios/{id}")
	public ResponseEntity<MessageDto> actualizarDatos(@PathVariable int id ,@Valid @RequestBody DatosUsuario datosUsuario) throws  AttributeException, ResourceNotFoundException{
		Optional<Usuario> opUsuario=usuarioService.findById(id);
		if(opUsuario.isPresent()) {
			datosUsuario.setCodigo_usuario(id);
			datosUsuarioService.save(datosUsuario);
			return ResponseEntity.ok(new MessageDto(HttpStatus.OK.value(),"Se actualizo los datos del usuario con éxito"));
		}else {
			throw new ResourceNotFoundException("Usuario no encontrado");
		}	
	}	
}
