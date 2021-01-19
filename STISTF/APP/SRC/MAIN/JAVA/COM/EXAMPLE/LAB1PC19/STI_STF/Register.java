package com.example.lab1pc19.sti_stf;

import android.content.ContentValues;
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

public class Register extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _btnLogin, _btnreg;
    EditText _txtStudentID, _txtlname, _txtfname, _txtmname, _txtcontact, _txtuname, _txtpass, _txtcpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new DatabaseHelper(this);
        _txtStudentID = (EditText) findViewById(R.id.txtStudentId);
        _txtlname = (EditText) findViewById(R.id.txtlname);
        _txtfname = (EditText) findViewById(R.id.txtfname);
        _txtmname = (EditText) findViewById(R.id.txtmname);
        _txtcontact = (EditText) findViewById(R.id.txtcontact);
        _txtuname = (EditText) findViewById(R.id.txtunameem);
        _txtpass = (EditText) findViewById(R.id.txtupass);
        _txtcpass = (EditText) findViewById(R.id.txtcpass);
        _btnreg = (Button) findViewById(R.id._btnreg);
        _btnLogin = (Button) findViewById(R.id.btnlinklogin);


        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getReadableDatabase();
                String studentid = _txtStudentID.getText().toString();
                String lname = _txtlname.getText().toString();
                String fname = _txtfname.getText().toString();
                String mname = _txtmname.getText().toString();
                String contact = _txtcontact.getText().toString();
                String uname = _txtuname.getText().toString();
                String pass = _txtpass.getText().toString();
                String cpass = _txtcpass.getText().toString();
                String mySQL = "select *from registration where STUDENTIDNO=? OR Username=?";
                String [] args = {studentid, uname};
                cursor = db.rawQuery(mySQL, args);
                //cursor = db.rawQuery("SELECT * FROM registration WHERE Username=?", new String[]{uname});
                if (cursor !=null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(Register.this, "Some info are already used",Toast.LENGTH_SHORT).show();
                    }
                    else if (studentid.equals("") || lname.equals("") || fname.equals("") || mname.equals("") || contact.equals("") || uname.equals("") || pass.equals("")) {
                        Toast.makeText(Register.this, "Please fill all the informations",Toast.LENGTH_SHORT).show();
                    }

                    else if (pass.length() < 8) {
                            Toast.makeText(Register.this, "Password must me atleast 8 characters", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        db = openHelper.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("STUDENTIDNO", _txtStudentID.getText().toString());
                        contentValues.put("LastName", _txtlname.getText().toString());
                        contentValues.put("FirstName", _txtfname.getText().toString());
                        contentValues.put("MiddleName", _txtmname.getText().toString());
                        contentValues.put("Contact", _txtcontact.getText().toString());
                        contentValues.put("Username", _txtuname.getText().toString());
                        contentValues.put("Password", _txtpass.getText().toString());
                        long id = db.insert("registration", null, contentValues);
                        Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_LONG).show();
                    }
                }
                else {Toast.makeText(Register.this, "SOMEBODY USED THAT",Toast.LENGTH_SHORT).show();}
            }
        });
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
    });

    }
}


