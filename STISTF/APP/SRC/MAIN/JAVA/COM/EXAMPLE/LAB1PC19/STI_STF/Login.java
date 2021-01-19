package com.example.lab1pc19.sti_stf;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _btnlog, _btnreg;
    EditText _txtEmail, _txtPass, _txtCpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _txtEmail = (EditText) findViewById(R.id.txtemail);
        _txtPass = (EditText) findViewById(R.id.txtpass);
        _txtCpass = (EditText) findViewById(R.id.txtCpass);
        _btnlog = (Button) findViewById(R.id.btnlog);
        _btnreg = (Button) findViewById(R.id.btnlinkreg);
        openHelper = new DatabaseHelper(this);


        _btnlog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = _txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();
                String cpass = _txtCpass.getText().toString();
               // String mySQL = "select * from registration where Username=? AND Password=?";
                //String [] args = {email, pass};

               // cursor = db.rawQuery(mySQL, args);
                db = openHelper.getWritableDatabase();
                cursor = db.rawQuery("SELECT * FROM registration WHERE Username=? AND Password=?", new String[]{email, pass});
                if (cursor !=null){
                    if (cursor.getCount() > 0)
                    {Toast.makeText(Login.this,"Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (Login.this, Red.class);
                    startActivity(intent);}
                    else if (email.equals("accountingtutor")&&(pass.equals("accountingtutor"))){

                        Intent intent = new Intent (Login.this, accountingtutorsActivity.class);
                        startActivity(intent);}

                }
                else {Toast.makeText(Login.this, "Login Error", Toast.LENGTH_SHORT).show();}
            }
        });
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

}
