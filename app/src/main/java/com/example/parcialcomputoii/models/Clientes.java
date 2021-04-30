package com.example.parcialcomputoii.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clientes {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;


    //Guardar
    public Clientes(String nombre, String apellido){

        this.nombre = nombre;
        this.apellido = apellido;

    }

    //Editar
    public Clientes(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Mensaje para saber que sí se guardó
    @Override
    public String toString(){

        return "Cliente{" +
                ",  nombre='"+ nombre + '\'' +
                ", apellido='"+ apellido + '\'' +
                '}';
    }

}
