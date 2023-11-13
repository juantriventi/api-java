package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String nombre;

    @ManyToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    //Constructor vacio para hibernate
    public Rol() {
    }

    // Constructor que toma un nombre como parámetro
    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.getRoles().add(this);
    }
    
    public void removerUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
        usuario.getRoles().remove(this);
    }

    @Override
    public String toString() {
        return getNombre();
    }

}
