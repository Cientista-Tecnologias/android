package com.example.ac.nyw.model;

import java.io.Serializable;

/**
 * Created by AC on 03/06/2016.
 */
public class Produto implements Serializable {
    private int codigo;
    private String nome;
    private String sobrenome;
    private String email;

    public Produto(){}

    public Produto(int codigo,String nome, String sobrenome,String email) {
        this.codigo=codigo;
        this.nome=nome;
        this.sobrenome=sobrenome;
        this.email=email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //==============================================================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    //==============================================================

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    //==============================================================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //==============================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return codigo == produto.codigo;

    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
