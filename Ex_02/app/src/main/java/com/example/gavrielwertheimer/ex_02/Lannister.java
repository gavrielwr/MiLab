package com.example.gavrielwertheimer.ex_02;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Lannister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister);

        List<Family> family = new ArrayList<>();

        family.add(new Family("Tywin",ContextCompat.getDrawable(this,R.drawable.tywin)));
        family.add(new Family("Cersei",ContextCompat.getDrawable(this,R.drawable.cersei)));
        family.add(new Family("Jaime",ContextCompat.getDrawable(this,R.drawable.jaime)));
        family.add(new Family("Joffrey",ContextCompat.getDrawable(this,R.drawable.joffrey)));
        family.add(new Family("Tyrion",ContextCompat.getDrawable(this,R.drawable.tyrion)));
        MyAdapter myAdapter = new MyAdapter(family);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lannisterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);
    }
}
