package com.example.ac.nyw.util;

import com.example.ac.nyw.model.Produto;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by AC on 03/06/2016.
 */
public class ProdutoDes implements JsonDeserializer<Produto > {

    @Override
    public Produto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement produto=json.getAsJsonObject();

        if(json.getAsJsonObject().get("produto")!=null){
            produto=json.getAsJsonObject();
        }
        return (new Gson().fromJson(produto,Produto.class));
    }
}
