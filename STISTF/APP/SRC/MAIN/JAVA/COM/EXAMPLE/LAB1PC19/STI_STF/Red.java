package com.example.lab1pc19.sti_stf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Red extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red);
    }
public void sched (View view){
    Intent i = new Intent (Red.this, Schedule.class);
    startActivity(i);}

    public void view (View view){
        Intent io = new Intent (Red.this, ViewAppointment.class);
        startActivity(io);}

}
