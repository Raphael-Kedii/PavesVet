package com.paves.pavesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SelectionActivity extends AppCompatActivity {
    Button farmers_button, experts_button;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        farmers_button = findViewById(R.id.farmers_btn);
        experts_button = findViewById(R.id.expert_btn);

        farmers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectionActivity.this, LoginActivity.class));
            }
        });
        experts_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectionActivity.this, ExpertLoginActivity.class));
            }
        });
    }
}
