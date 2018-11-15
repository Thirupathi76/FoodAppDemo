package com.marolix.aromafood;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.marolix.aromafood.appapi.AppApi;
import com.marolix.aromafood.appapi.AppService;
import com.marolix.aromafood.bean.Categories;
import com.marolix.aromafood.utils.Constants;
import com.marolix.aromafood.utils.Utilities;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 2000;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        progressBar = findViewById(R.id.progressBar);
//        progressBar.setBackgroundColor(Color.parseColor("#ff0000"));
        Response();
        new Handler().postDelayed(new Runnable() {


            /* * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company*/


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, NavDrawerActivity.class);
                startActivity(i);
                Response();
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    void Response() {
        AppService service = AppApi.createAppService(SplashActivity.this);
        Call<Categories> call = service.getCategories();
        progressBar.setVisibility(View.VISIBLE);
        

        call.enqueue(new Callback<Categories>() {

            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
//                pd.dismiss();

                Log.e("Response code  ", String.valueOf(response.code()));
                if (response.isSuccessful()) {
//                    JSONObject object = new JSONObject(response.body());
                    Log.e("Response", response.toString());
                    progressBar.setVisibility(View.GONE);
                    Utilities.setPreference(SplashActivity.this, Constants.CATEGORY_1, response.body().getCategoryOne());
                    Utilities.setPreference(SplashActivity.this, Constants.CATEGORY_2, response.body().getCategoryTwo());
                    Utilities.setPreference(SplashActivity.this, Constants.CATEGORY_3, response.body().getCategoryThree());

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);

                    /*prodLists = response.body().getCategories();
                    ProductListAdapter adapter = new ProductListAdapter(SplashActivity.this, prodLists);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();*/
//                    Log.e("travel list", travelList.get(0).getDistance());

                } else
                    Toast.makeText(SplashActivity.this, "Data not available", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
//                pd.dismiss();
                progressBar.setVisibility(View.GONE);
                Log.e("Exception throw", t.getMessage());
                Toast.makeText(SplashActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
