package com.android.hacsystem.android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.hacsystem.android.R;
import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.controller.ClientesController;
import com.android.hacsystem.android.model.Clientes;

public class MainActivity extends AppCompatActivity {

    ClientesController clientesController;

    Clientes cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(ApiUtil.TAG, "onCreate: App Minha Idéia BD");

        clientesController = new ClientesController(getApplicationContext());

        for(int i = 0; i < 30; i++) {

            cliente = new Clientes();

            cliente.setNomeCliente("Helinton_"+ (1 + i));
            cliente.setEmailCliente("helinton_" + (1 + i) + "@teste.com");

            clientesController.criar(cliente);
        }

    }
}