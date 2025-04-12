package com.example.tp5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText editTextName;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        if (prefs.contains("username")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        editTextName = findViewById(R.id.editTextName);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            if (!name.isEmpty()) {
                prefs.edit().putString("username", name).apply();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });
    }
}
