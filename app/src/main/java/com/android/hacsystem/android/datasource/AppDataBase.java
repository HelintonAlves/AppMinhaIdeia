package com.android.hacsystem.android.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.datamodel.ClientesDataModel;
import com.android.hacsystem.android.datamodel.ProdutosDataModel;

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

        Log.d(ApiUtil.TAG,"comando sql: " + ClientesDataModel.criarTabela());

        db.execSQL(ProdutosDataModel.criarTabela());

        Log.d(ApiUtil.TAG, "comando sql: " + ProdutosDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados){

        db = getWritableDatabase();
        boolean retorno = false;
        try{

            retorno = db.insert(tabela, null, dados) > 0;

        }catch (Exception e){
            Log.d(ApiUtil.TAG,"insert: " + e.getMessage());
        }

        return retorno;
    }
}
