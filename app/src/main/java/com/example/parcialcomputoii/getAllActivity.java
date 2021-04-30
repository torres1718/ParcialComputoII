package com.example.parcialcomputoii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parcialcomputoii.interfarces.ClienteAPI;
import com.example.parcialcomputoii.models.Clientes;
import com.example.parcialcomputoii.remote.CLIENTEUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class getAllActivity extends AppCompatActivity {

    ClienteAPI clienteAPI;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);

        clienteAPI = CLIENTEUtils.getClientAPI();
        listView = findViewById(R.id.listview);

        getClientes();
    }

    public void getClientes(){

        Call<List<Clientes>> listCall = clienteAPI.getClientes();
        listCall.enqueue(new Callback<List<Clientes>>() {
            @Override
            public void onResponse(Call<List<Clientes>> call, Response<List<Clientes>> response) {
                List<Clientes> clientesList = response.body();

                String[] clientes = new String[clientesList.size()];

                for(int i=0; i<clientesList.size(); i++){
                    clientes[i] = clientesList.get(i).getNombre();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_expandable_list_item_1, clientes));
            }

            @Override
            public void onFailure(Call<List<Clientes>> call, Throwable t) {

                Toast.makeText(getAllActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void addCliente(View v){

        Intent intent = new Intent(getAllActivity.this, MainActivity.class);
        startActivity(intent);

    }
    public void editCliente(View v){

        Intent intent = new Intent(getAllActivity.this, editActivity.class);
        startActivity(intent);

    }

}