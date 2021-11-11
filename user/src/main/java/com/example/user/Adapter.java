package com.example.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Details> coursesArrayList;
    private Context context;

    // creating constructor for our adapter class
    public Adapter(ArrayList<Details> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.service_details, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        Details courses = coursesArrayList.get(position);
       // holder.name.setText(courses.getName());
        holder.shop.setText(courses.getShop());
        holder.co1.setText(courses.getPhone());
        holder.co2.setText(courses.getAlternative());
        holder.Address.setText(courses.getAddress());
       // holder.service.setText(courses.getService());
       // holder.pincode.setText(courses.getPincode());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return coursesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
      //  private final TextView name;
        private final TextView shop;
      //  private final TextView pincode;
        private  final Button button1;
        private final TextView co1;
        private final TextView co2;
        private final TextView Address;
     //  private final TextView service;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
          //  name= itemView.findViewById(R.id.name);
            shop = itemView.findViewById(R.id.shop);
          //  pincode = itemView.findViewById(R.id.pin);
            co1 = itemView.findViewById(R.id.co1);
            co2 = itemView.findViewById(R.id.co2);
            Address = itemView.findViewById(R.id.add);
            button1 =  itemView.findViewById(R.id.button1);
          //  service = itemView.findViewById(R.id.service);

        }
    }
}



