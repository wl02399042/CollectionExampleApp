package com.collectionexample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.collectionexample.layout.VolleyLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {

    private VolleyLayout volleyLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volleyLayout = new VolleyLayout(this);
        setContentView(volleyLayout);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, "http://www.google.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyLayout.getStringText().setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyLayout.getStringText().setText("Oh NO！");
            }
        });
        RequestQueue imgrequest = Volley.newRequestQueue(this);
        ImageRequest imageRequest = new ImageRequest("http://i.imgur.com/7spzG.png", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                volleyLayout.getImage().setImageBitmap(bitmap);
            }
        },200,100, ImageView.ScaleType.CENTER_INSIDE, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyLayout.getImage().setImageResource(R.mipmap.ic_launcher);
            }
        });
        RequestQueue jsonrequest = Volley.newRequestQueue(this);
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET,"http://www.w3schools.com/json/myTutorials.txt", new Response.Listener<String>() {
            @Override
            public void onResponse(String json) {
                int firstIndex=json.indexOf('[');
                json=json.substring(firstIndex,json.length());
                try {
                    Log.d("one","get");
                    JSONArray jsonArray = new JSONArray(json);
                    String X="";
                    Log.d("two","get");
                    for(int i=0; i<jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        String display = obj.getString("display");
                        X=X+display+"\n";
                        volleyLayout.getJsonText().setText(X);
                        Log.d("get","get");
                    }

                } catch (JSONException e) {
                    Log.d("json","error",e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyLayout.getJsonText().setText("null");
            }
        });
                queue.add(request);
                imgrequest.add(imageRequest);
                jsonrequest.add(jsonObjectRequest);
    }
}
