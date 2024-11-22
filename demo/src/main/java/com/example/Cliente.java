package com.example.Entidad;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entidad
public class Cliente {
    @Id
    @GeneratedValue((strategy = GenerationType.IDENTITY))
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private int telefono;

    public long getId (){
        return id;
    }

    public void setId (long id){
        this.id;
    }

    public String getNombre (){
        return nombre;
    }

    public void setNombre (String nombre){
        this.nombre;
    }

    public String getEmail (){
        return.email;
    }

    public void setEmail (String email){
        this.email;
    }

    public int getTelefono (){
        return telefono;
    }

    public void setTelefono (int telefono){
        this.telefono;
    }
}