package com.example.app_rendamos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_rendamos.data.APIClient;
import com.example.app_rendamos.data.Authentication;
import com.example.app_rendamos.data.DataProvider;
import com.example.app_rendamos.data.model.LogInResponse;
import com.example.app_rendamos.data.model.LoggedInUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HEAD;

public class MainActivity extends AppCompatActivity {
    private EditText cajaDNI;
    private EditText cajaPW;
    public boolean exito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaDNI=findViewById(R.id.dni);
        cajaPW=findViewById(R.id.editText3);
        //startActivity(new Intent(getApplicationContext(), UserList.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isNetworkConnected()){
              Toast.makeText(getApplicationContext(), "La aplicación necesita de una conexión a internet para funcionar", Toast.LENGTH_LONG).show();
            }
    }

    //Verifica si hay conexion
    private boolean isNetworkConnected() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        return connected;
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
        String[] valores = new String [2];
        String usuario = cajaDNI.getText().toString();
        String contrasenya = cajaPW.getText().toString();
        if(!usuario.isEmpty() && !contrasenya.isEmpty() ){
            if (usuario.length()<=10) {
                boolean esNumero=true;
                try {
                    int dni = Integer.parseInt(usuario);
                }
                catch (Exception e) {
                    Toast.makeText(this, "Usuario inválido", Toast.LENGTH_LONG).show();
                    esNumero=false;
                    exito = false;

                }
                if(esNumero) {
                    valores[0] = usuario;
                    exito=true;
                }
            }
            else {
                Toast.makeText(this, "Usuario inválido: máximo 10 dígitos", Toast.LENGTH_LONG).show();
                exito = false;
            }
            if (contrasenya.length()<=10 && contrasenya.length()>=8 ){
                valores[1] =contrasenya;
                exito=exito&&true;
            }
            else{
                Toast.makeText(this, "Contraseña inválida: debe tener entre 8 y 10 caracteres", Toast.LENGTH_LONG).show();
                exito = false;
            }
        }
        else{
            Toast.makeText(this, "Debe ingresar el usuario y la contraseña" ,Toast.LENGTH_LONG).show();
            exito = false;
        }

        if(getExitoDatos()){
            attemptLogin(valores[0], valores[1]);
        }

    }

    public boolean getExitoDatos(){
        return this.exito;
    }

    public void attemptLogin(String username, String password){
        APIClient client = DataProvider.getApiClient(getApplicationContext());
        Call<LogInResponse> call = client.logInCall(new LoggedInUser(username,password));
        call.enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                try{
                    if (response.body() != null && response.body().getUserInfo() != null){
                        // Credenciales correctos
                        String authToken = String.valueOf(response.body().getLoginData().getAccess_token());
                        Authentication.setDefaults("token", authToken, getApplicationContext());
                        // To retrieve use String token = preferences.getString("token","");
                        Intent intent = new Intent(getApplicationContext(), UserList.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "El usuario y/o la contraseña son inválidos", Toast.LENGTH_LONG).show();
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
