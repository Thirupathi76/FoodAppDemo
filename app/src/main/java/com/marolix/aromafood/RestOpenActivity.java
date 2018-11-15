package com.marolix.aromafood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RestOpenActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    String[] rest_name = {"Pizzahut", "Burger King", "Subway", "Dominos", "KFC", "Mc Donalds", "Pizzahut", "Burger King", "Subway", "Dominos", "KFC", "Mc Donalds", "Pizza"};

    int[] rests = {R.drawable.pizza_hut, R.drawable.burger_king, R.drawable.subway, R.drawable.dominos, R.drawable.imgpsh_fullsize_kfc,
            R.drawable.imgpsh_fullsize, R.drawable.pizza_hut, R.drawable.burger_king, R.drawable.subway, R.drawable.dominos, R.drawable.imgpsh_fullsize_kfc,
            R.drawable.imgpsh_fullsize, R.drawable.pizza_hut};

    private Button order_now_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.text);
        String po = getIntent().getStringExtra("Position1");
        textView.setText(rest_name[Integer.parseInt(po)]);

        order_now_btn = findViewById(R.id.order_now_btn);
        order_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RestOpenActivity.this, ProductActivity.class));
            }
        });
        String position = getIntent().getStringExtra("POSITION");
        imageView = findViewById(R.id.tem_1);
        imageView.setImageResource(rests[Integer.parseInt(position)]);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(rest_name[Integer.parseInt(po)]);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
