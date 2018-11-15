package com.marolix.aromafood.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marolix.aromafood.R;
import com.marolix.aromafood.adapter.RestListAdapter;
import com.marolix.aromafood.interfaces.ClickListener;

public class FragMyOrders extends Fragment {

    /*ProgressDialog mProgressDialog;
    private List<JobListItem> jobListItems;
    private RecyclerView recyclerView;*/

    String[] rest_name = {"Pizzahut", "Burger King", "Subway", "Dominos", "KFC", "Mc Donalds", "Pizzahut", "Burger King", "Subway", "Dominos", "KFC", "Mc Donalds", "Pizza"};
    int[] rests = {R.drawable.pizza_hut, R.drawable.burger_king, R.drawable.subway, R.drawable.dominos, R.drawable.imgpsh_fullsize_kfc,
            R.drawable.imgpsh_fullsize,R.drawable.pizza_hut, R.drawable.burger_king, R.drawable.subway, R.drawable.dominos, R.drawable.imgpsh_fullsize_kfc,
            R.drawable.imgpsh_fullsize, R.drawable.pizza_hut};
    String[] prod_price = {"20", "40", "30", "25", "30", "20", "30", "40", "30", "25", "30", "20", "30"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_two, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RestListAdapter adapter = new RestListAdapter(getActivity(), rest_name, prod_price, rests, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int qua) {
                if (view.getId() == R.id.img_add) {

                    Log.e("Click ", "databaseCart " + pos);
                    /*total = total + Integer.parseInt(prod_price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to databaseCart items " + total);
                    if (total == 0){
                        bottom_cart_layout.setVisibility(View.GONE);
                    }*/

                } else if (view.getId() == R.id.img_sub) {
                    Log.e("Click ", "databaseCart " + pos);

                    /*total = total - Integer.parseInt(prod_price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to databaseCart items " + total);
                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }*/
                }
            }
        });
        recyclerView.setAdapter(adapter);
       /* recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<ChatBean> list = new ArrayList<>();
        jobListItems = new ArrayList<>();*/



        return view;

    }


}
