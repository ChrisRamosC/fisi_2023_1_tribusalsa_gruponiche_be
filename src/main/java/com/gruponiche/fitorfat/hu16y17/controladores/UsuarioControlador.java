/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruponiche.fitorfat.hu16y17.controladores;

import com.gruponiche.fitorfat.hu16y17.entidades.dto.IAmigoDTO;
import com.gruponiche.fitorfat.hu16y17.servicios.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase para manejar las solicitudes vía REST
 */
@RestController

@RequestMapping("/ux-retar-amigo-rutinas/fitorfat/servicio-al-cliente/v1/amigos")
@AllArgsConstructor
public class UsuarioControlador {
    private final UsuarioServicio uServ;

    @GetMapping("/consultar-amigos/{id}")
    public List<IAmigoDTO> getAmigos(@PathVariable Integer id) {
        return uServ.listarAmigos(id);
    }
}
