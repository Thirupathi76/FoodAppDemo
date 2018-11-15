package com.marolix.aromafood.appapi;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppApi {

    public static final String ROOT_URL = "https://github.com/sumanthdarsi/AromaFood/raw/master/";
//    public static final String BASE_URL = "https://raw.githubusercontent.com/sumanthdarsi/Uddan/master/product_list.json";
    public static final String BASE_URL = "https://github.com/Thirupathi76/SearchMap/raw/master/Parkingplaces/";

    public static AppService createAppService(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//gson
                .client(client)
                .build();

        return retrofit.create(AppService.class);
    }


}
