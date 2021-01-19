package com.example.lab1pc19.sti_stf;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class accountingskedActivity extends AppCompatActivity {

    accountingskedhelper Buti_Pa_Yung_Database_May_Koneksyon;
    private EditText Tagapasok_1Etx;
    private RadioButton Tagapasok_1Rdo;
    private RadioButton Tagapasok_2Rdo;
    private RadioButton Tagapasok_3Rdo;
    private String Tagapasok_3Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountingsked);

        Buti_Pa_Yung_Database_May_Koneksyon = new accountingskedhelper(this);

        String status = "Waiting for response";

        Tagapasok_1Etx = (EditText)findViewById(R.id.Tagapasok_1Etx_Id);
        Tagapasok_1Rdo = (RadioButton)findViewById(R.id.Tagapasok_1Rdo_Id);
        Tagapasok_2Rdo = (RadioButton)findViewById(R.id.Tagapasok_2Rdo_Id);
        Tagapasok_3Rdo = (RadioButton)findViewById(R.id.Tagapasok_3Rdo_Id);
        Tagapasok_3Str = status;

    }

    public void hanapngbagogawinmo (View v) {
        if (Tagapasok_1Rdo.isChecked()) {
            boolean isInserted = Buti_Pa_Yung_Database_May_Koneksyon.hanapngbago(
                    Tagapasok_1Etx.getText().toString(),
                    Tagapasok_1Rdo.getText().toString(),//Tagapasok_2Etx.getText().toString(
                    Tagapasok_3Str
            );
            if (isInserted == true)
                Toast.makeText(getApplicationContext(), "Validating Your Request", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Sorry We Can't Process Your Request", Toast.LENGTH_LONG).show();
        }
        else if (Tagapasok_2Rdo.isChecked()) {
            boolean isInserted = Buti_Pa_Yung_Database_May_Koneksyon.hanapngbago(
                    Tagapasok_1Etx.getText().toString(),
                    Tagapasok_2Rdo.getText().toString(),//Tagapasok_2Etx.getText().toString()
                    Tagapasok_3Str
            );
            if (isInserted == true)
                Toast.makeText(getApplicationContext(), "Validating Your Request", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Sorry We Can't Process Your Request", Toast.LENGTH_LONG).show();
        }
        else if (Tagapasok_3Rdo.isChecked()) {
            boolean isInserted = Buti_Pa_Yung_Database_May_Koneksyon.hanapngbago(
                    Tagapasok_1Etx.getText().toString(),
                    Tagapasok_3Rdo.getText().toString(),//Tagapasok_2Etx.getText().toString()
                    Tagapasok_3Str
            );
            if (isInserted == true)
                Toast.makeText(getApplicationContext(), "Validating Your Request", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Sorry We Can't Process Your Request", Toast.LENGTH_LONG).show();
        }
    }

    public void gehtignanmoulet(View v) {
        Cursor res = Buti_Pa_Yung_Database_May_Koneksyon.gehtignanmoulet();
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()) {
            //buffer.append("Request Id: "+res.getString(0)+"\n");
            buffer.append("Student Name: "+res.getString(1)+"\n");
            buffer.append("Requested Tutor: "+res.getString(2)+"\n");
            buffer.append("Response: "+res.getString(3)+"\n"+"\n"+"\n");
        }
        showMessage("Tutorial Lessons",buffer.toString());
    }


    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
