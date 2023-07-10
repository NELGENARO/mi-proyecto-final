package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;

    public ArrayList<DepartamentoModel> obtenerDepartamentos(){
        return (ArrayList<DepartamentoModel>) departamentoRepository.findAll();
    }

    public DepartamentoModel guardarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public DepartamentoModel actualizarDepartamento(DepartamentoModel departamentoModel, Integer id){
        // return departamentoRepository
        Optional<DepartamentoModel> departamento = departamentoRepository.findById(id);
        if (departamento.isPresent()){
            DepartamentoModel data =  departamento.get();
            data.setCapital(departamentoModel.getCapital());
            data.setHabitantes(departamentoModel.getHabitantes());
            data.setNombre(departamentoModel.getNombre());
            data.setTerritorio(departamentoModel.getTerritorio());
            departamentoRepository.save(data);
            return data;
        }else{
            return null;
        }
    }

    public Optional<DepartamentoModel> obtenerDepartamento(Integer id){
        return departamentoRepository.findById(id);
    }
    
    public Map<String, Boolean> eliminarDepartamento(Integer id){
        HashMap<String, Boolean> map = new HashMap<>();
        if(departamentoRepository.findById(id).isPresent()){
            departamentoRepository.deleteById(id);
            map.put("Resultado", Boolean.valueOf(true));
        }else{
            map.put("Resultado", Boolean.valueOf(false));
        }
        // try {
            // System.out.println("=========="+departamentoRepository.findById(id).toString()+"=============");;
            // departamentoRepository.deleteById(id);
            // map.put("Resultado", Boolean.valueOf(true));
        // } catch (Exception e) {
            // map.put("Resultado", Boolean.valueOf(false));
        // }
        return map;
    }
}
