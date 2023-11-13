package com.example.demo.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rol;
import com.example.demo.models.Usuario;
import com.example.demo.services.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        System.out.println(usuarioService.listarUsuarios());
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        Set<Rol> rol = usuario.getRoles();
        System.out.println("Usuario creado " + usuario.getNombre() + " " + usuario.getApellido() + " con el rol " + rol);
        return usuarioService.crearUsuario(usuario.getNombre(), usuario.getApellido(), rol);
    }

    @PutMapping("/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        Set<Rol> roles = usuario.getRoles();
        System.out.println("Usuario editado: " + usuario.getNombre() + " " + usuario.getApellido() + " " + roles);
        return usuarioService.editarUsuario(usuario.getId(), usuario.getNombre(), usuario.getApellido(), roles);
    }

    @PostMapping("/eliminar/{id}")
    public Usuario eliminUsuario(@PathVariable Long id) {
        System.out.println("Eliminando el usuario con ID: " + id);
        return usuarioService.eliminarUsuario(id);
    }

}
