package com.gruponiche.fitorfat.hu16y17.servicios;

import com.gruponiche.fitorfat.hu16y17.entidades.dto.IAmigoDTO;
import com.gruponiche.fitorfat.hu16y17.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio repoU;

    public List<IAmigoDTO> listarAmigos(Integer id){

        return repoU.listaAmigos(id);
    }


}
