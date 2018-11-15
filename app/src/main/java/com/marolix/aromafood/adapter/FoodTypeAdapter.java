package com.marolix.aromafood.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marolix.aromafood.NavDrawerActivity;
import com.marolix.aromafood.R;

public class FoodTypeAdapter extends RecyclerView.Adapter<FoodTypeAdapter.MyViewHolder> {

    String[] prod_name = {"Breakfast", "Lunch", "Snacks", "Dinner"};
    int  Images[] = {R.drawable.breakfast,R.drawable.lunch,R.drawable.snacks,R.drawable.dinner};
    Context context;

    public FoodTypeAdapter(Context mainActivity) {
        context = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_type_list_item, viewGroup, false);

        /*String sth = null;
        Object obj = null;
        sth.equals(obj);
        if(sth == obj);*/

//        view.setOnClickListener(MainActivity.myOnClickListener);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        myViewHolder.prod_image.setImageResource(Images[i]);
        myViewHolder.productName.setText(prod_name[i]);
        myViewHolder.prod_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NavDrawerActivity.class);
                intent.putExtra("PRODUCT_NAME", prod_name[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return prod_name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productName;
        ImageView prod_image;
        int sum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            prod_image = itemView.findViewById(R.id.product_image);

        }

    }
}
