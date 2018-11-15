package com.marolix.aromafood;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {

    TextView text;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        text = findViewById(R.id.result_text);

        dialog = new ProgressDialog(LoadingActivity.this);

        dialog.setTitle("Please wait");
        dialog.setMessage("Preparing resources...");
        dialog.setCancelable(false);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
                text.setVisibility(View.VISIBLE);

            }
        }, 3000);

    }
}
