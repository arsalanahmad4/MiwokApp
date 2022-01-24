package com.example.ud839_miwok_lesson_one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding numbers TextView
        TextView numbers = findViewById(R.id.numbers);
        //setting onClickListener on numbers
        numbers.setOnClickListener(new View.OnClickListener(){
            //overriding onClick method from OnCLickListener Interface
            @Override
            public void onClick(View view){
                //Creating intent and starting numbers activity
                Intent numberIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numberIntent);
            }
        });

        TextView family = findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        TextView colors = findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorIntent);
            }
        });

        TextView phrases = findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phraseIntent = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phraseIntent);
            }
        });
    }

//    public void openNumbersList(View view){
//        Intent numberIntent = new Intent(this, NumbersActivity.class);
//        startActivity(numberIntent);
//    }
//    public void openFamilyList(View view){
//        Intent familyIntent = new Intent(this, FamilyActivity.class);
//        startActivity(familyIntent);
//    }
//    public void openColorList(View view){
//        Intent colorIntent = new Intent(this,ColorsActivity.class);
//        startActivity(colorIntent);
//    }
//    public void openPhraseList(View view){
//        Intent phraseIntent = new Intent(this,PhrasesActivity.class);
//        startActivity(phraseIntent);
//    }

}