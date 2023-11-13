package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Rol;
import com.example.demo.repositories.RolRepository;
import com.example.demo.services.IRolService;

@Service
public class RolService implements IRolService {

  private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public Optional<Rol> obtenerPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    @Override
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }
}
