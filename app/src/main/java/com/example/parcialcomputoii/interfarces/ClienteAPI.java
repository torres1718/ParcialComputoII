package com.example.parcialcomputoii.interfarces;


import com.example.parcialcomputoii.models.Clientes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClienteAPI {
    @GET("apiclientes/clientefilter.php/")
    public Call<Clientes> find(@Query("id") String id);
}
