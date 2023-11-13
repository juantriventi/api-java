package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Rol;

public interface IRolService {

    Optional<Rol> obtenerPorNombre(String nombre);    

    List<Rol> obtenerTodos();

}
