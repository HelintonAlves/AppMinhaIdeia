package com.android.hacsystem.android.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.datamodel.ClientesDataModel;
import com.android.hacsystem.android.datamodel.ProdutosDataModel;
import com.android.hacsystem.android.model.Clientes;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeiaDB.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClientesDataModel.criarTabela());

        Log.d(ApiUtil.TAG, "comando sql: " + ClientesDataModel.criarTabela());

        db.execSQL(ProdutosDataModel.criarTabela());

        Log.d(ApiUtil.TAG, "comando sql: " + ProdutosDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();
        boolean retorno = false;
        try {

            retorno = db.insert(tabela, null, dados) > 0;

        } catch (Exception e) {
            Log.d(ApiUtil.TAG, "insert: " + e.getMessage());
        }

        return retorno;
    }

    public boolean deleteById(String tabela, int id) {

        db = getWritableDatabase();
        boolean retorno = false;
        try {

            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;

        } catch (Exception e) {
            Log.d(ApiUtil.TAG, "delete: " + e.getMessage());
        }

        return retorno;
    }

    public boolean update(String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            retorno = db.update(tabela, dados, "id = ?", new String[]{String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {
            Log.d(ApiUtil.TAG, "upadte: " + e.getMessage());
        }

        return  retorno;

    }

    @SuppressLint("Range")
    public List<Clientes> getAllClientes(String tabela){

        db = getWritableDatabase();

        List<Clientes> clientes = new ArrayList<>();
        Clientes cliente;

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do{
                cliente  = new Clientes();
                cliente.setId(cursor.getInt(cursor.getColumnIndex(ClientesDataModel.ID)));
                cliente.setEmailCliente(cursor.getString(cursor.getColumnIndex(ClientesDataModel.NOME)));
                cliente.setEmailCliente(cursor.getString(cursor.getColumnIndex(ClientesDataModel.EMAIL)));

                clientes.add(cliente);
            }while (cursor.moveToNext());
        }

        return clientes;
    }


}


