package com.android.hacsystem.android.datamodel;

import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;

public class ClientesDataModel {

    public static final String TABELA = "cliente";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    public static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, " ;
        queryCriarTabela += NOME + " text, " ;
        queryCriarTabela += EMAIL + " text" + ")";

        Log.d(ApiUtil.TAG, "criarTabela: "+queryCriarTabela);

        return queryCriarTabela;
    }



}
