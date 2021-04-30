package com.example.parcialcomputoii.interfarces;


import com.example.parcialcomputoii.models.Clientes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ClienteAPI {
    @GET("apiclientes/clientefilter.php/")
    public Call<Clientes> find(@Query("id") String id);

    @GET("apiclientes/read.php")
    Call<List<Clientes>> getClientes();

    @POST("apiclientes/create.php")
    Call<Clientes> saveClientes(@Body Clientes clientes);

    @PUT("apiclientes/update.php")
    Call<Clientes> updateClientes(@Body Clientes clientes);

    @DELETE("apicliente/delete.php/")
    Call<Clientes> deleteClientes(@Query("id") String id);
}
