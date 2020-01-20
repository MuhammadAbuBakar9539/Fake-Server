package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userName, password;
    private Button login;
    private boolean isValid;

    public static final String KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.et_userName);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FakeServer fs = (FakeServer) getIntent().getParcelableExtra("regObj");
                isValid = fs.validate(userName.getText().toString(), password.getText().toString());

                if(isValid == true){
                    Intent intent = new Intent(LoginActivity.this, WelocomeActivity.class);
                    intent.putExtra(KEY, userName.getText().toString());
                    userName.getText().clear();
                    password.getText().clear();
                    startActivity(intent);
                }
                else if(isValid != true && userName.length() != 0 && password.length() != 0){
                    Toast.makeText(getApplicationContext(), "WARNING! User Name or Password is incorrect!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Field(s) can't be empty.", Toast.LENGTH_LONG).
                            show();
                }
            }
        });
    }
}
