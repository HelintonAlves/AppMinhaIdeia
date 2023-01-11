package com.android.hacsystem.android.datamodel;


import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;

public class ProdutosDataModel {

    public static final String TABELA = "fornecedor";
    public static final String ID = "id";
    public static final String PRODUTO = "nomeProduto";
    public static final String FORNECEDOR = "fornecedorProduto";

    public static String queryCriaTabela = "";

    public static String criarTabela(){

        queryCriaTabela += "CREATE TABLE " + TABELA + " (";
        queryCriaTabela += ID + " integer primary key autoincrement, ";
        queryCriaTabela += PRODUTO + " text, ";
        queryCriaTabela += FORNECEDOR + " text" + ")";

        Log.d(ApiUtil.TAG, "Tabela Produto criada...  " + queryCriaTabela);

        return queryCriaTabela;
    }


}
