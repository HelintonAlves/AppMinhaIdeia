package com.android.hacsystem.android.model;

import android.util.Log;

import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.controller.ICrud;

public class Clientes{

    private int id;
    private String nomeCliente;
    private String emailCliente;

    public int getId(){ return id; }

    public void setId(int id) { this.id = id; }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente(){
        return nomeCliente;
    }

    public void setEmailCliente(String emailCliente){
        this.emailCliente = emailCliente;
    }


}
