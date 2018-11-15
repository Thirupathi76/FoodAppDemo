package com.marolix.aromafood.fragments;

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marolix.aromafood.interfaces.ClickListener;
import com.marolix.aromafood.PaymentActivity;
import com.marolix.aromafood.R;
import com.marolix.aromafood.adapter.RecyclerAdapter;
import com.marolix.aromafood.utils.Utilities;

import java.util.ArrayList;

public class FragFoodCourt extends Fragment {


    LinearLayout bottom_cart_layout;
    TextView text_cart;
    private int total;
    String[] prod_name = {"Idly", "Dosa", "Uthappa", "Naan", "Roti", "Bajji", "Puri"};
    String[] prod_price = {"20", "40", "30", "25", "30", "20", "30"};
    int[] images = {R.drawable.idly, R.drawable.dosa, R.drawable.dosa, R.drawable.naan, R.drawable.naan,
            R.drawable.idly, R.drawable.puri};
    private ArrayList<String> name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_product, container, false);
        Log.i("onCreateView", "called");

        // Alert dialog functionality


       /* final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Do you want to open this?");
        builder.setMessage("Marolix.com");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // ok action

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // cancel action
                AlertDialog dialog = builder.create();
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();*/

        /*WebView webView = view.findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl("http://www.marolix.com");*/

        bottom_cart_layout = view.findViewById(R.id.bottom_cart_layout);
        text_cart = view.findViewById(R.id.cart_text);
        final String product_name = getActivity().getIntent().getStringExtra("PRODUCT_NAME");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), prod_name, prod_price, images, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int sth) {
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
}
