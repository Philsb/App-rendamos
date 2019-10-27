package com.example.app_rendamos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.app_rendamos.data.model.StudentResponse;
import com.google.gson.Gson;

public class StudentInfoActivity extends AppCompatActivity {
    private TextView nombre;
    private TextView fecha;
    private TextView semanas;
    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        nombre = findViewById(R.id.idNino);
        fecha= findViewById(R.id.fnn);
        semanas=findViewById(R.id.spn);
        test=findViewById(R.id.tan);

        String jsonStr = getIntent().getExtras().getString("serialize_data");
        StudentResponse studentResponse = new Gson().fromJson(jsonStr, StudentResponse.class);
        nombre.setText(studentResponse.getFirstName() + " " + studentResponse.getLastName());
        fecha.setText(studentResponse.getDob().substring(0,10));
        semanas.setText(String.valueOf(studentResponse.getEarlyBirthAmount()));
        test.setText(studentResponse.getForm().getName());
        Log.d("Fdn", studentResponse.getDob());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Salir) {
            AlertDialog.Builder builder = new AlertDialog.Builder(StudentInfoActivity.this);
            builder.setMessage("¿Desea salir de la aplicación?").setPositiveButton ("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO devolverse a log in screen
                            Intent act =new Intent(getApplicationContext(), MainActivity.class);
                            act.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }

                    }
            )
                    .setNegativeButton("Cancel", null).setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
