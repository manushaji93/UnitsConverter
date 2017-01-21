package com.example.manushaji.unitsconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
    }

    public void crossPressed (View view){
        finish();
    }
}
