package com.sanguo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.sanguo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView main_iv_01;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_iv_01 = (ImageView) findViewById(R.id.main_iv_01);
        main_iv_01.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //intent = new Intent(MainActivity.this, HomeActivity.class);
        intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}