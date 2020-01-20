package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText userName, password;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        final FakeServer fakeServer = new FakeServer();

        userName = findViewById(R.id.et_user_name_reg);
        password = findViewById(R.id.et_password_reg);
        register = findViewById(R.id.btn_reg);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = userName.getText().toString();
                String uPassword = password.getText().toString();

                if(uName.length() == 0 || uPassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Field(s) can't be empty.",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    fakeServer.registerUser(uName, uPassword);

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("regObj", fakeServer);
                    userName.getText().clear();
                    password.getText().clear();
                    finish();
                    startActivity(intent);
                }
            }
        });
    }
}
