package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Details extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView titleTextView;
    TextView countryDescTextView;
    TextView currencyTextView;
    TextView languageTextView;
    TextView capitalTextView;
    TextView otherTextView;
    String country;
    int imageResourse;
    String countrydesc;
    String currency;
    String language;
    String capital;
    String other;

    FloatingActionButton addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        imageView=findViewById(R.id.image);
        titleTextView=findViewById(R.id.titleTextView);
        countryDescTextView =findViewById(R.id.countryDesctextView);
        currencyTextView = findViewById(R.id.currencyTextView);
        languageTextView =findViewById(R.id.languageTextView);
        capitalTextView = findViewById(R.id.capitalTextView);
        otherTextView = findViewById(R.id.otherTextView);

        country=getIntent().getStringExtra("titleTextView");
        imageResourse=getIntent().getIntExtra("image",0);
        countrydesc = getIntent().getStringExtra("countryDescTextView");
        currency = getIntent().getStringExtra("currencyTextView");
        language = getIntent().getStringExtra("languageTextView");
        capital = getIntent().getStringExtra("capitalTextView");
        other = getIntent().getStringExtra("otherTextView");

        titleTextView.setText(country);
        imageView.setImageResource(imageResourse);
        countryDescTextView.setText(countrydesc);
        currencyTextView.setText(currency);
        languageTextView.setText(language);
        capitalTextView.setText(capital);
        otherTextView.setText(other);



        addbtn=(FloatingActionButton) findViewById(R.id.notepadbutton);
        addbtn.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Details.this, NoteActivity.class);
        startActivity(intent);
    }
}
