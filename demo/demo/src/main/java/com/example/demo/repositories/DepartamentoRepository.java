package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.DepartamentoModel;


@Repository
public interface DepartamentoRepository extends CrudRepository<DepartamentoModel, Integer>{
    
}
