package com.example.app_rendamos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.app_rendamos.data.APIClient;
import com.example.app_rendamos.data.Authentication;
import com.example.app_rendamos.data.DataProvider;
import com.example.app_rendamos.data.model.LogInResponse;
import com.example.app_rendamos.data.model.StudentResponse;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserList extends AppCompatActivity {
    private ArrayList<StudentResponse> studentResponse = new ArrayList<StudentResponse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("UserList", "onCreate.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        getMyStudents();
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
            AlertDialog.Builder builder = new AlertDialog.Builder(UserList.this);
            builder.setMessage("¿Desea salir de la aplicación?").setPositiveButton ("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO devolverse a log in screen
                           // startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }

                    }
            )
                    .setNegativeButton("Cancel", null).setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(UserList.this);
            builder.setMessage("¿Desea salir de la aplicación?").setPositiveButton ("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            UserList.super.onBackPressed();
                        }

                    }
            )
                    .setNegativeButton("Cancel", null).setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();
            return false; //I have tried here true also
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initRecyclerView(){
        Log.d("UserList", "Init Recycler View .");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter  adapter = new RecyclerViewAdapter(this, studentResponse);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getMyStudents(){
        APIClient client = DataProvider.getApiClient(getApplicationContext());
        Call<List<StudentResponse>> call = client.getAllStudents("Bearer " + Authentication.getDefaults("token", getApplicationContext()));
        call.enqueue(new Callback<List<StudentResponse>>() {
            @Override
            public void onResponse(Call<List<StudentResponse>> call, Response<List<StudentResponse>> response) {
                try{
                    if(response.body() != null){
                        if(response.body().size() > 0) {
                            for (StudentResponse student : response.body()) {
                                //Log.d("Estudiante: ", student.getFirstName() + " " + student.getLastName());
                                studentResponse.add(student);
                            }
                        }
                    }
                    else{
                        Toast.makeText(UserList.this, "No posee niños asociados.", Toast.LENGTH_SHORT).show();
                    }
                }   catch(Exception e){
                    e.printStackTrace();
                }
                initRecyclerView();
            }

            @Override
            public void onFailure(Call<List<StudentResponse>> call, Throwable t) {
                Log.d("d","onFailure");
            }
        });
    }

}
