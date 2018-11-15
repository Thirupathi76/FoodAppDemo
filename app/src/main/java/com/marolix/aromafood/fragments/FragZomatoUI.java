package com.marolix.aromafood.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marolix.aromafood.LoadingActivity;
import com.marolix.aromafood.ProductActivity;
import com.marolix.aromafood.RestaurantsActivity;
import com.marolix.aromafood.adapter.FoodListAdapter;
import com.marolix.aromafood.adapter.RestHorizListAdapter;
import com.marolix.aromafood.interfaces.ClickListener;
import com.marolix.aromafood.PaymentActivity;
import com.marolix.aromafood.R;
import com.marolix.aromafood.utils.Utilities;

import java.util.ArrayList;

public class FragZomatoUI extends Fragment implements View.OnClickListener {


    LinearLayout bottom_cart_layout;
    TextView text_cart,tiffins_seemore, rest_seemore;
    CardView card_pizza_subway;

    private int total;
    String[] prod_name = {"Idly", "Dosa", "Uthappa", "Naan", "Roti", "Bajji", "Puri"};
    String[] rest_name = {"Pizzahut", "Burger King", "Subway", "Dominos", "KFC", "Mc Donalds", "Pizza"};
    String[] prod_price = {"20", "40", "30", "25", "30", "20", "30"};
    int[] images = {R.drawable.idly, R.drawable.dosa, R.drawable.dosa, R.drawable.naan, R.drawable.naan,
            R.drawable.idly, R.drawable.puri};
    int[] rests = {R.drawable.pizza_hut, R.drawable.burger_king, R.drawable.subway, R.drawable.dominos, R.drawable.imgpsh_fullsize_kfc,
            R.drawable.imgpsh_fullsize, R.drawable.pizza_hut};
    private ArrayList<String> name;
    private ImageView grid_one, grid_two, grid_three, grid_four, grid_five, grid_six;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_zomato_ui, container, false);
        Log.i("onCreateView", "called");

        bottom_cart_layout = view.findViewById(R.id.bottom_cart_layout);
        text_cart = view.findViewById(R.id.cart_text);
        rest_seemore = view.findViewById(R.id.rest_seemore);
        tiffins_seemore = view.findViewById(R.id.tiffins_seemore);
        tiffins_seemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProductActivity.class));
            }
        });
        card_pizza_subway = view.findViewById(R.id.card_pizza_subway);
        card_pizza_subway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RestaurantsActivity.class));
            }
        });
        rest_seemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RestaurantsActivity.class));
            }
        });
        final String product_name = getActivity().getIntent().getStringExtra("PRODUCT_NAME");

        grid_one = view.findViewById(R.id.grid_one);
        grid_two = view.findViewById(R.id.grid_two);
        grid_three = view.findViewById(R.id.grid_three);
        grid_four = view.findViewById(R.id.grid_four);
        grid_five = view.findViewById(R.id.grid_five);
        grid_six = view.findViewById(R.id.grid_six);

        grid_one.setOnClickListener(this);
                grid_two.setOnClickListener(this);
        grid_three.setOnClickListener(this);
                grid_four.setOnClickListener(this);
        grid_five.setOnClickListener(this);
                grid_six.setOnClickListener(this);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_one);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        RestHorizListAdapter adapter = new RestHorizListAdapter(getActivity(), rest_name, prod_price, rests, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int qua) {
                if (view.getId() == R.id.img_add) {
                    Log.e("Click ", "cart " + pos);
                    total = total + Integer.parseInt(prod_price[pos]);

                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to cart items " + total);
                    if (total == 0){
                        name = new ArrayList<>();
                        name.add(prod_name[pos]);
//                        Utilities.setArrayPreference(getActivity(), "PROD_LIST", );
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                } else if (view.getId() == R.id.img_sub) {
                    Log.e("Click ", "cart " + pos);

                    total = total - Integer.parseInt(prod_price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to cart items " + total);
                    if (total == 0){
                        name.remove(prod_name[pos]);
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                }
            }
        });
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView_two);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        FoodListAdapter adapter2 = new FoodListAdapter(getActivity(), prod_name, prod_price, images, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int qua) {
                if (view.getId() == R.id.img_add) {
                    Log.e("Click ", "cart " + pos);
                    total = total + Integer.parseInt(prod_price[pos]);

                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to cart items " + total);
                    if (total == 0){
                        name = new ArrayList<>();
                        name.add(prod_name[pos]);
//                        Utilities.setArrayPreference(getActivity(), "PROD_LIST", );
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                } else if (view.getId() == R.id.img_sub) {
                    Log.e("Click ", "cart " + pos);

                    total = total - Integer.parseInt(prod_price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to cart items " + total);
                    if (total == 0){
                        name.remove(prod_name[pos]);
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                }
            }
        });
        recyclerView2.setAdapter(adapter2);
        bottom_cart_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                intent.putExtra("CART", String.valueOf(total));
                Utilities.setPreference(getActivity(), "ORDER_AMOUNT", String.valueOf(total));
                Utilities.setArrayPreference(getActivity(), "ORDER_DETAILS", name);
                startActivity(intent);

            }
        });

        text_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                intent.putExtra("CART", String.valueOf(total));
                Utilities.setPreference(getActivity(), "ORDER_AMOUNT", String.valueOf(total));
                Utilities.setArrayPreference(getActivity(), "ORDER_DETAILS", name);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.grid_one:
                startActivity(new Intent(getActivity(), RestaurantsActivity.class));
                break;
            case R.id.grid_two:
                startActivity(new Intent(getActivity(), LoadingActivity.class));
                break;
            case R.id.grid_three:
                startActivity(new Intent(getActivity(), LoadingActivity.class));
                break;
            case R.id.grid_four:
                startActivity(new Intent(getActivity(), LoadingActivity.class));
                break;
            case R.id.grid_five:
                startActivity(new Intent(getActivity(), LoadingActivity.class));
                break;
            case R.id.grid_six:
                startActivity(new Intent(getActivity(), LoadingActivity.class));
                break;

        }
    }
}
