package com.android.hacsystem.android.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.datamodel.ClientesDataModel;
import com.android.hacsystem.android.datasource.AppDataBase;
import com.android.hacsystem.android.model.Clientes;

import java.util.ArrayList;
import java.util.List;

public class ClientesController extends AppDataBase implements ICrud<Clientes>{

    ContentValues values;

    public ClientesController(Context context) {
        super(context);

        Log.i(ApiUtil.TAG, "ClientesController: Acessando o banco de dados");
    }

    @Override
    public boolean criar(Clientes cliente) {

        values = new ContentValues();
        values.put(ClientesDataModel.NOME, cliente.getNomeCliente());
        values.put(ClientesDataModel.EMAIL, cliente.getEmailCliente());

        return insert(ClientesDataModel.TABELA, values);
    }

    @Override
    public boolean alterar(Clientes cliente) {

        values = new ContentValues();
        values.put(ClientesDataModel.ID, cliente.getId());
        values.put(ClientesDataModel.NOME, cliente.getNomeCliente());
        values.put(ClientesDataModel.EMAIL, cliente.getEmailCliente());

        return update(ClientesDataModel.TABELA, values);
    }

    @Override
    public boolean delete(int id) {

        return deleteById(ClientesDataModel.TABELA, id);
    }

    @Override
    public List<Clientes> listar() {

        return getAllClientes(ClientesDataModel.TABELA);
    }

}
