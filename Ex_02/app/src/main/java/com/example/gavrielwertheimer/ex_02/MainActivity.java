package com.example.gavrielwertheimer.ex_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button starkButton = findViewById(R.id.Stark_button);
        Button lannisterButton = findViewById(R.id.Lannister_button);
        starkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Stark.class);
                startActivity(intent);
            }
        });

        lannisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Lannister.class);
                startActivity(intent);
            }
        });


    }


}

