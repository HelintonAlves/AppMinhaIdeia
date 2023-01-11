package com.android.hacsystem.android.controller;

import android.content.ContentValues;
import android.content.Context;

import com.android.hacsystem.android.datamodel.ProdutosDataModel;
import com.android.hacsystem.android.datasource.AppDataBase;
import com.android.hacsystem.android.model.Produtos;

import java.util.ArrayList;
import java.util.List;

public class ProdutosController extends AppDataBase implements ICrud<Produtos> {

    ContentValues valuesProduto;

    public ProdutosController(Context context) {
        super(context);
    }


    @Override
    public boolean criar(Produtos produto) {

        valuesProduto = new ContentValues();
        valuesProduto.put("nomeProduto", produto.getNomeProduto());
        valuesProduto.put("fornecedorProduto", produto.getFornecedorProduto());

        return insert(ProdutosDataModel.TABELA, valuesProduto);
    }

    @Override
    public boolean alterar(Produtos produto) {

        valuesProduto = new ContentValues();
        valuesProduto.put("idProduto", produto.getId());
        valuesProduto.put("nomeProduto", produto.getNomeProduto());
        valuesProduto.put("fornecedorProduto", produto.getFornecedorProduto());

        return false;
    }

    @Override
    public boolean delete(Produtos produto) {

        valuesProduto = new ContentValues();
        valuesProduto.put("idProduto", produto.getId());

        return false;
    }

    @Override
    public List<Produtos> listar() {

        List<Produtos> listaProdutos = new ArrayList<>();

        return listaProdutos;
    }
}
