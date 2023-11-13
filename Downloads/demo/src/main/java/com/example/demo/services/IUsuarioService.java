package com.example.demo.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.models.Rol;
import com.example.demo.models.Usuario;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface IUsuarioService {

    List<Usuario> listarUsuarios();

    Usuario crearUsuario(String nombre, String apellido, Set<Rol> rol);

    Usuario editarUsuario(Long id, String nombre, String apellido,  Set<Rol> rol);

    Usuario eliminarUsuario(Long id);

}
