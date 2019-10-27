package com.example.app_rendamos;
import android.content.Context;
import android.net.ConnectivityManager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_rendamos.data.APIClient;
import com.example.app_rendamos.data.DataProvider;
import com.example.app_rendamos.data.model.LogInResponse;
import com.example.app_rendamos.data.model.LoggedInUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    //Verifica si hay conexion
    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    //Verifica si esta conectado a internet
    public boolean internetIsConnected() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
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
                    Toast.makeText(this, "Usuario inválido", Toast.LENGTH_LONG).show();
                    esNumero=false;

                }
                if(esNumero) {
                    valores[0] = usuario;
                    exito=true;
                }
            }
            else {
                Toast.makeText(this, "Usuario inválido", Toast.LENGTH_LONG).show();
            }
            if (contrasenya.length()<=10 && contrasenya.length()>=8 ){
                valores[1] =contrasenya;
                exito=exito&&true;
            }
            else{
                Toast.makeText(this, "Contraseña inválido", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "DEBE ingresar el usuario y la contraseña" ,Toast.LENGTH_LONG).show();
        }
        if(getExitoDatos()){
            attemptLogin(getUser(), getPass());
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

    private void attemptLogin(String username, String password){
        APIClient client = DataProvider.getApiClient();
        Call<LogInResponse> call = client.logInCall(new LoggedInUser(username,password));
        call.enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                try{

                    if (response.body().getUserInfo() != null){
                        // Credenciales correctos
                    }
                }   catch(Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                Log.d("d","onFailure");
            }
        });
    }
}
