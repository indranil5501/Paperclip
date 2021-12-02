package com.example.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class gsadapter extends RecyclerView.Adapter<gsadapter.myviewholder> {

    ArrayList<model> datalist;

    public gsadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custome,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.sn.setText(datalist.get(position).getShopname());
        holder.on.setText(datalist.get(position).ownname);
        holder.add.setText(datalist.get(position).getShopadd());
        //holder.num.setOnClickListener(); calling

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView sn,on,add;
        Button num;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            sn= itemView.findViewById(R.id.shopName);
            on= itemView.findViewById(R.id.ownname);
            add= itemView.findViewById(R.id.add);
            num= itemView.findViewById(R.id.call);

        }
    }
}
