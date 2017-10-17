package com.gdgandroidbolivia.mywonderful;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements WonderAdapter.onWonderSelectedListener{
         //BEFORE  public class MainActivity extends AppCompatActivity
    RecyclerView wonderRecyclerView;
    WonderAdapter wonderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wonderRecyclerView = (RecyclerView) findViewById(R.id.recycle_main);
        wonderRecyclerView.setHasFixedSize(true);
        wonderRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //wonderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        wonderAdapter = new WonderAdapter(this, this);

        llenarDatos ();
        wonderRecyclerView.setAdapter(wonderAdapter);
    }
    private void llenarDatos(){
        List<Wonder> lista = new ArrayList<>();

        lista.add(new Wonder(R.drawable.b, " A", getString(R.string.Descripcion_b)));
        lista.add(new Wonder(R.drawable.g, " B", getString(R.string.Descripcion_g)));
        lista.add(new Wonder(R.drawable.o, " C", getString(R.string.Descripcion_o)));
        lista.add(new Wonder(R.drawable.q, " D", getString(R.string.Descripcion_q)));
        lista.add(new Wonder(R.drawable.r, " E", getString(R.string.Descripcion_r)));
        lista.add(new Wonder(R.drawable.u, " F", getString(R.string.Descripcion_u)));
        lista.add(new Wonder(R.drawable.x, " G", getString(R.string.Descripcion_x)));
        lista.add(new Wonder(R.drawable.y, " H", getString(R.string.Descripcion_y)));
        lista.add(new Wonder(R.drawable.z, " I", getString(R.string.Descripcion_z)));
        lista.add(new Wonder(R.drawable.def, " J", getString(R.string.Descripcion_def)));

        wonderAdapter.setDataSet (lista);
    }
    @Override
    public void onWonderSelected(Wonder wonder) {
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("wonder", wonder);
        startActivity(intent);
    }
}