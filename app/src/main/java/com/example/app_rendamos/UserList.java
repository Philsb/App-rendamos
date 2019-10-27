package com.example.app_rendamos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class UserList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
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
                            Toast.makeText(UserList.this, "Ir a login screen", Toast.LENGTH_SHORT).show();
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


}
