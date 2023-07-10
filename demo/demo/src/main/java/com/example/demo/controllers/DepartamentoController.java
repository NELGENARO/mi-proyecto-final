package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController  {
    @Autowired
    DepartamentoService departamentoService;

    // @CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin(origins = "*", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @GetMapping
    public ArrayList<DepartamentoModel> obtenerDepartamentos(){
        return departamentoService.obtenerDepartamentos();
    }

    @CrossOrigin(origins = "*")
    @PostMapping 
    public DepartamentoModel guardarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        System.out.println(departamentoModel);
        return this.departamentoService.guardarDepartamento(departamentoModel);    
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/{id}")
    public DepartamentoModel updateDepartamento(@PathVariable("id") Integer id, @RequestBody DepartamentoModel departamentoModel) {
        return this.departamentoService.actualizarDepartamento(departamentoModel, id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @GetMapping(path = "/{id}")
    public Optional<DepartamentoModel> obtenerDepartamento(@PathVariable("id") Integer id){
        return this.departamentoService.obtenerDepartamento(id);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> eliminarDepartamento(@PathVariable("id") Integer id){
        System.out.println(id);
        return this.departamentoService.eliminarDepartamento(id);
    }
}
