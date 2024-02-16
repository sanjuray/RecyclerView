package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {
    private ArrayList<Item> itemList;

    public ItemClickListener clickListener;

    public void setItemClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public MyCustomAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,
                        parent,
                        false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemImage.setImageResource(item.getItemImage());
        holder.itemTitle.setText(item.getItemTitle());
        holder.itemDescription.setText(item.getItemDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageView);
            itemTitle = itemView.findViewById(R.id.title);
            itemDescription = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onCLick(v, getAdapterPosition());
            }
        }
    }
}
