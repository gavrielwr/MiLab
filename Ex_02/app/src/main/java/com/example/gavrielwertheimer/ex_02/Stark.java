package com.example.gavrielwertheimer.ex_02;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Stark extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Family> family = new ArrayList<>();

        family.add(new Family("Eddard",ContextCompat.getDrawable(this,R.drawable.eddard)));
        family.add(new Family("Catelyn",ContextCompat.getDrawable(this,R.drawable.catelyn)));
        family.add(new Family("Robb",ContextCompat.getDrawable(this,R.drawable.robb)));
        family.add(new Family("Jon Snow",ContextCompat.getDrawable(this,R.drawable.jon)));
        family.add(new Family("Arya",ContextCompat.getDrawable(this,R.drawable.arya)));
        family.add(new Family("Sansa",ContextCompat.getDrawable(this,R.drawable.sansa)));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark);

        MyAdapter myAdapter = new MyAdapter(family);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.starkList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);


    }
}
