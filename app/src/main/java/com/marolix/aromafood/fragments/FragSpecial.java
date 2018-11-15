package com.marolix.aromafood.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marolix.aromafood.R;

public class FragSpecial extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("onAttach", "called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate", "called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);


        Log.i("onCreateView", "called");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("onActivityCreated", "called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("onPause", "called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("onResume", "called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("onStart", "called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("onStop", "called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("onAttach", "called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("onDestroyView", "called");
    }
}
