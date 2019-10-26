package com.example.app_rendamos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText cajaDNI;
    private EditText cajaPW;
    private String [] valores;
    public boolean exito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaDNI=findViewById(R.id.dni);
        cajaPW=findViewById(R.id.editText3);
        valores = new String [2];
    }

    public void recuperaDatos(View ver){
        exito=false;
        String usuario = cajaDNI.getText().toString();
        String contrasenya = cajaPW.getText().toString();
        if(!usuario.isEmpty() && !contrasenya.isEmpty() ){
            if (usuario.length()<10) {
                boolean esNumero=true;
                try {
                    int dni = Integer.parseInt(usuario);
                }
                catch (Exception e) {
                    Toast.makeText(this, "Usuario inválido", Toast.LENGTH_SHORT).show();
                    esNumero=false;

                }
                if(esNumero) {
                    valores[0] = usuario;
                    exito=true;
                }
            }
            else {
                Toast.makeText(this, "Usuario inválido", Toast.LENGTH_SHORT).show();
            }
            if (contrasenya.length()<=10 && contrasenya.length()>=8 ){
                valores[1] =contrasenya;
                exito=exito&&true;
            }
            else{
                Toast.makeText(this, "Contraseña inválido", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "DEBE ingresar el usuario y la contraseña" ,Toast.LENGTH_SHORT).show();
        }
    }

    public boolean getExitoDatos(){
        return this.exito;
    }

    public String getUser(){
        return valores[0];
    }

    public String getPass(){
        return valores[1];
    }
}
