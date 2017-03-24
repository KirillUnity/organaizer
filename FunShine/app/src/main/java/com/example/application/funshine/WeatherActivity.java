package com.example.application.funshine;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    final String URL_BASE="http://api.openweathermap.org/data/2.5/forecast";
    final String URL_COORD="/city?id=524901";
    final String URL_API_KEY="&APPID=74b410ba30d5f0e814816cd62c161790";
   // 47.2116076,39.6517943,
   //  74b410ba30d5f0e814816cd62c161790
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        final String url=URL_BASE+URL_COORD+URL_API_KEY;
        final JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("Fun","RES: "+response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Fun","Err: "+error.getLocalizedMessage());
            }
        });

        Volley.newRequestQueue(this).add(jsonRequest);
    }
}
