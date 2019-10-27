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
import android.widget.Toast;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    private ArrayList<Pair<String,String>> mNameList = new ArrayList<Pair<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("UserList", "onCreate.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        testListView();
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
            builder.setMessage("¿Desea salir?").setPositiveButton ("Ok", new DialogInterface.OnClickListener() {
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
            builder.setMessage("¿Desea salir?").setPositiveButton ("Ok", new DialogInterface.OnClickListener() {
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

    //Metodo para probar si la lista funca bien
    private void testListView () {
        mNameList.add(Pair.create("Jeff","Test autentico"));
        mNameList.add(Pair.create("Javier","Test 666"));
        mNameList.add(Pair.create("Edwin","Test Cosmico"));
        mNameList.add(Pair.create("Eric","Test Vaticano"));
        mNameList.add(Pair.create("Carlitos Johnson","Test Cumbion loco"));
        mNameList.add(Pair.create("Harina","Test Coca"));
        mNameList.add(Pair.create("Icaco","Test frutal"));
        mNameList.add(Pair.create("Sardimar","Test atunero"));
        mNameList.add(Pair.create("Cacao Garapiñado","Test El dawg"));
        mNameList.add(Pair.create("Carlitos2 Johnson","Test Cumbion loco"));
        mNameList.add(Pair.create("Hari123na","Test Coca"));
        mNameList.add(Pair.create("Ica2co","Test frutal"));
        mNameList.add(Pair.create("Sardimar","Test atunero"));
        mNameList.add(Pair.create("Cacao Garapiñado33","Test El dawg"));
        mNameList.add(Pair.create("Carlitos Johnso32n","Test Cumbion loco"));
        mNameList.add(Pair.create("Harina123","Test Coca"));
        mNameList.add(Pair.create("Icac123o","Test frutal"));
        mNameList.add(Pair.create("Sardi414mar","Test atunero"));
        mNameList.add(Pair.create("Cacao Gar1414apiñado","Test El dawg"));

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d("UserList", "Init Recycler View .");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter  adapter = new RecyclerViewAdapter(this, mNameList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
