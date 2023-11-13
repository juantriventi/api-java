package com.example.demo.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Rol;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.RolRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; 

    @Autowired
    private RolRepository rolRepository;


    //Lista de usuarios
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Crear usuarios
    @Override
    public Usuario crearUsuario(String nombre, String apellido, Set<Rol> roles) {
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty() || roles == null || roles.isEmpty()) {
            throw new IllegalArgumentException("Nombre, apellido y roles no pueden ser nulos o vacíos.");
        }

        Set<Rol> existingRoles = new HashSet<>();

        for (Rol rol : roles) {
            // Se fija si el rol ya existe
            Optional<Rol> existingRolOptional = rolRepository.findByNombre(rol.getNombre());

            if (existingRolOptional.isPresent()) {
                // Si el rol existe lo usa
                existingRoles.add(existingRolOptional.get());
            } else {
                // Si no existe tira error
                throw new IllegalArgumentException("El rol '" + rol.getNombre() + "' no es un rol válido.");
            }
        }

        Usuario usuario = new Usuario(nombre, apellido);
        usuario.setRoles(existingRoles);

        return usuarioRepository.save(usuario);
    }

    //Editar un usuario
    @Override
    public Usuario editarUsuario(Long id, String nombre, String apellido, Set<Rol> roles) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
    
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setRoles(roles);
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("No existe el usuario que quieres editar");
        }
    }
    

    //Elimina un usuario por id
    @Override
    public Usuario eliminarUsuario(Long id) {
        if (id <= 0){
            throw new IllegalArgumentException("El id proporcionado no es valido");
        }
        usuarioRepository.deleteById((long) id);
        return null;
    }

}

