package com.globalsit.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.globalsit.test.volleycomun.HttpError;
import com.globalsit.test.volleycomun.HttpListener;
import com.globalsit.test.volleycomun.HttpGet;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListaComida();
            }
        });
    }

    private void ListaComida()
    {

        final String url = "http://globalsitcorp.com/delivery/backend/Index.php/api/getListFoodByShop";
        Map<String, String> params = new HashMap<>();
        params.put("s_id", "1");
        new HttpGet(this, url, params, true, new HttpListener() {
            @Override
            public void onHttpResponse(Object response) {
                if (response != null) {
                    String json = response.toString();
                    Log.i("Success", json);
                } else {
                    Log.i("Success", "Sin Datos");
                }
            }
        }, new HttpError() {
            @Override
            public void onHttpError(VolleyError volleyError) {

                Log.e("Error", volleyError.toString());
            }
        });
    }
}