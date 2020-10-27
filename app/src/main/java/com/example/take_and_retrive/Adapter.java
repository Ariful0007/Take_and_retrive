package com.example.take_and_retrive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.google.firebase.database.core.Context;

import java.util.List;

public class Adapter extends  RecyclerView.Adapter<Adapter.mybiewHolder>{
    MainActivity2 context;
    List<ModelUser>modelList;

    public Adapter(MainActivity2 context, List<ModelUser> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public mybiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.myview,parent,false);
        return new mybiewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mybiewHolder holder, int position) {
        //String message1=chatModelList.get(position).getMessage();
        String  text=modelList.get(position).getName();
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  class  mybiewHolder extends ViewHolder {
        TextView textView;
        public mybiewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.name);
        }


    }
}
