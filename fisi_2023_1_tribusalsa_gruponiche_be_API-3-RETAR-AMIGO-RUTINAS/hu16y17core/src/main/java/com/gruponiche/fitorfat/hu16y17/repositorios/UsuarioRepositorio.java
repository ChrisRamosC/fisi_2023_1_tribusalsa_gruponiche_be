package com.gruponiche.fitorfat.hu16y17.repositorios;

import com.gruponiche.fitorfat.hu16y17.entidades.Usuario;
import com.gruponiche.fitorfat.hu16y17.entidades.dto.IAmigoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    @Query(nativeQuery = true, value ="SELECT u.codigo, a.codigo_usuario, u.nombre, u.telefono, u.correo, u.es_Premium, u.imagen  \n" +
            "FROM usuario u  JOIN  amigos a ON u.codigo\n" +
            "= a.codigo_amigo  WHERE a.codigo_usuario = :id")
    List<IAmigoDTO> listaAmigos(@Param("id") Integer id);
}