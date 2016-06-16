package com.example.ac.nyw.resources;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.ac.nyw.model.Produto;
import com.example.ac.nyw.services.ProdutosServices;
import com.example.ac.nyw.util.ProdutoDes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AC on 03/06/2016.
 */
public class BuscarProdutosAsync extends AsyncTask<Void,Void,String > {
 //==============================================================
   //private TextView textViewBA;
   //private ProdutosServices ps;
    //ArrayAdapter<String> adapter;
    //=================================================================
    private Context context;
    public static final String TAG = "RETROFIT";

    public BuscarProdutosAsync(Context context){
        this.context=context;
        //this.ps=ps;
    }
    //==============================================================================================
    //primeiro metódo
    @Override
    protected void onPreExecute() {
        //progress = new ProgressDialog(context);
        //progress.setMessage("Carregando arquivo...");
       // progress.show();
    }
    //==============================================================================================
    //segunda metódo
    @Override
    protected String doInBackground(Void... params) {
        //todo consumir webservice

        String baseurl = "http://192.168.1.118:80/php_retornado_JSON.php/";
        Gson gsonConverter = new GsonBuilder().registerTypeAdapter(Produto.class, new ProdutoDes())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                .build();
        ProdutosServices services = retrofit.create(ProdutosServices.class);
        Call<List<Produto>> listaProdutoServices = services.buscarTodos();

        listaProdutoServices.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                List<Produto> produtos = response.body();
                //lista de produtos vista em log
                //criei uma
                for (Produto p : produtos) {
                    Log.i(TAG, p.getNome());
                }
            }
            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return null;

    }
    //==============================================================================================
    //Último metódo
     @Override
     protected void onPostExecute(String  result) {
         super.onPostExecute(result);
         //ps.dados(result);

    }
    }

