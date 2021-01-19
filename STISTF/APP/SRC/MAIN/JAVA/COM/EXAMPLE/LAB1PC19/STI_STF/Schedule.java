package com.example.lab1pc19.sti_stf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }
    public void accounting (View view){
        Intent i = new Intent (Schedule.this, accountingskedActivity.class);
        startActivity(i);}

}
