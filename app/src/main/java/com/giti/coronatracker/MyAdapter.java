package com.giti.coronatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Countries> list;
    public MyAdapter(Context context, List<Countries> list)
    {
        this.context=context;
        this.list=list;
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.singlerow, parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        Countries country=list.get(position);
        holder.name.setText(country.getCountry());
        holder.tConfirmed.setText("Total Confirmed Cases : " + country.getTotalConfirmed());
        holder.tDeath.setText("Total Deaths : " + country.getTotalDeaths());
        holder.tRecovered.setText("Total Recovered Cases : " + country.getTotalRecovered());

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,tConfirmed,tDeath,tRecovered;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.country_name);
            tConfirmed=itemView.findViewById(R.id.c_t_c_s);
            tDeath=itemView.findViewById(R.id.c_t_d);
            tRecovered=itemView.findViewById(R.id.c_t_r_c);
        }
    }
}
