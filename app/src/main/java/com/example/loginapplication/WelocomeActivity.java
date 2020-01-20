package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelocomeActivity extends AppCompatActivity {

    TextView greeting;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welocome);

        name = getIntent().getStringExtra(LoginActivity.KEY);
        greeting = findViewById(R.id.tvWelcome);
        greeting.setText(getString(R.string.welocme, name));
    }
}
