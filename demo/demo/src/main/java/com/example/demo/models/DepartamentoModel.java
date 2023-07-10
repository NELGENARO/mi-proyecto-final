package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String nombre;
    private int habitantes;
    private String capital;
    private Float territorio;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Integer getHabitantes(){
        return this.habitantes;
    }

    public void setHabitantes(Integer habitantes){
        this.habitantes = habitantes;
    }

    public String getCapital(){
        return this.capital;
    }

    public void setCapital(String capital){
        this.capital = capital;
    }

    public Float getTerritorio(){
        return this.territorio;
    }

    public void setTerritorio(Float territorio){
        this.territorio = territorio;
    }
}
