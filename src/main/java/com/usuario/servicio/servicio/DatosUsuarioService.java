package com.usuario.servicio.servicio;

import com.usuario.servicio.entidades.DatosUsuario;
import com.usuario.servicio.utils.AttributeException;

public interface DatosUsuarioService {
	public void saveDatosUsuario(DatosUsuario datosUsuario) throws  AttributeException;
	public DatosUsuario save(DatosUsuario usuario) throws AttributeException;
}
