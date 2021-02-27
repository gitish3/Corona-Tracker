package com.giti.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CoronaDetail detail=new CoronaDetail();
    private TextView gConfirmed,gDeath,gRecovered;
    private List<Countries> list;
    private RecyclerView recyclerView;
    private   MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Covid Tracker");
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF3700B3"));

        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        list=new ArrayList<>();
        init();
        loadData();
    }

    private void init() {
        gConfirmed=findViewById(R.id.g_t_c_s);
        gDeath=findViewById(R.id.g_t_d);
        gRecovered=findViewById(R.id.g_t_r_c);

  recyclerView=findViewById(R.id.country_list);

 adapter=new MyAdapter(this,list);
  recyclerView.setLayoutManager(new LinearLayoutManager(this));
  recyclerView.setAdapter(adapter);
    }

    //loading data from API
    private void loadData() {

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="https://api.covid19api.com/summary";

    //MAKING NEW REQUEST
 JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, (response) -> {

            //SUCCESSFULL
            Log.e("RESPONSE : ",response.toString());

        Gson son=new Gson();
            detail=son.fromJson(response.toString(),CoronaDetail.class);
           String str= detail.getGlobal().getTotalConfirmed();
          Log.e("Total cases : ",str);

          gConfirmed.setText("Total Confirmed Cases : "+detail.getGlobal().getTotalConfirmed());
          gDeath.setText("Total Deaths : "+detail.getGlobal().getTotalDeaths());
          gRecovered.setText("Total Recovered Cases : "+detail.getGlobal().getTotalRecovered());

//          list.clear();

          for(Countries c: detail.getCountries())
          {
              list.add(c);
          }
adapter.notifyDataSetChanged();

        }, (error) -> {

            //ERROR
            Log.e("ERROR : ",error.toString());
        });


//ADD REQUEST TO REQUEST QUEUE
requestQueue.add(request);

    }
}