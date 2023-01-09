package com.android.hacsystem.android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.hacsystem.android.R;
import com.android.hacsystem.android.api.ApiUtil;
import com.android.hacsystem.android.controller.ClientesController;

public class MainActivity extends AppCompatActivity {

    ClientesController clientesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(ApiUtil.TAG, "onCreate: App Minha Idéia BD");

        clientesController = new ClientesController(getApplicationContext());
    }
}