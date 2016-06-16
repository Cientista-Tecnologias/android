package com.example.ac.nyw.services;

import com.example.ac.nyw.model.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by AC on 03/06/2016.
 */
public interface ProdutosServices {
    //=============================================
    public String dados(String letras);
    //===================================================
    @GET("buscarTodos")
    public Call<List<Produto>> buscarTodos();
     @GET("buscar/{id}")
    public Call<List<Produto>>buscar(@Path("id") int id);


}

