package com.android.hacsystem.android.model;

import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.controller.ICrud;

public class Produtos {

    private int id;
    private String nomeProduto;
    private String fornecedorProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFornecedorProduto(){
        return fornecedorProduto;
    }

    public void setFornecedorProduto(String fornecedorProduto){
        this.fornecedorProduto = fornecedorProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
