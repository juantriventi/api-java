package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rol;
import com.example.demo.services.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final IRolService rolService;

    public RolController(IRolService rolService){
        this.rolService = rolService;
    }

    @GetMapping("/listar")
        public List<Rol> listaRoles(){
        System.out.println();
        return rolService.obtenerTodos();
    }

}
