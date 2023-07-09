package com.usuario.servicio.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.usuario.servicio.entidades.DatosUsuario;
import com.usuario.servicio.repositorio.DatosUsuarioRepository;
import com.usuario.servicio.utils.AttributeException;

@Service
public class DatosUsuarioServiceImpl implements DatosUsuarioService{
	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;
	
	@Override
	@Transactional
	public void saveDatosUsuario(DatosUsuario datosUsuario) throws  AttributeException {
		if(datosUsuario.getSexo()!= 'M' && datosUsuario.getSexo()!='F' ) {
			throw new AttributeException("Sexo inválido");
		}
		datosUsuarioRepository.saveDatosUsuario(datosUsuario.getEdad(),datosUsuario.getSexo(),datosUsuario.getPeso(),datosUsuario.getTalla(),
				datosUsuario.getNivel_actividad(),datosUsuario.getZona_objetivo(), datosUsuario.getObjetivo(), datosUsuario.getCodigo_usuario());
	}

	@Override
	public DatosUsuario save(DatosUsuario datosUsuario) throws AttributeException {
		// TODO Auto-generated method stub
		return datosUsuarioRepository.save(datosUsuario);
	}
	
	
}
