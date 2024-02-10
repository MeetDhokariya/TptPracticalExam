package com.example.tptpracticalexam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tptpracticalexam.R;
import com.example.tptpracticalexam.model.ToysModel;

import java.util.ArrayList;
import java.util.List;

public class ToysAdapter extends RecyclerView.Adapter<ToysAdapter.DataViewHolder> {

    Context context;
    List<ToysModel> toysList =  new ArrayList<>();

    public ToysAdapter(Context context, List<ToysModel> l1) {

        this.context = context;
        toysList = l1;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.toys_tile,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.toyimg.setImageResource(toysList.get(position).toyimage);
        holder.txtname.setText(toysList.get(position).toyname);
        holder.txtprice.setText(toysList.get(position).price);
        holder.tileclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, toysList.get(position).toyname, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return toysList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        TextView txtname,txtprice;
        ImageView toyimg;
        LinearLayout tileclick;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            toyimg = itemView.findViewById(R.id.toyimg);
            txtname = itemView.findViewById(R.id.txtname);
            txtprice = itemView.findViewById(R.id.txtprice);
            tileclick = itemView.findViewById(R.id.tileclick);
        }
    }
}
