package com.example.consumows;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.consumows.WebService.Asynchtask;
import com.example.consumows.WebService.WebService;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class actValidaLogin extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_valida_login);
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://uealecpeterson.net/ws/login.php?usr="
                + bundle.getString("usr") + "&pass=" + bundle.getString("pass"),
                datos, actValidaLogin.this, actValidaLogin.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {

        TextView txtMensaje = (TextView)findViewById(R.id.lblMensaje);
        txtMensaje.setText("Respuesta del WS: " + result);


    }
}