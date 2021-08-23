package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ForgotpasswordActivity extends AppCompatActivity {
    EditText etemail;
    Button reset_button;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        etemail = findViewById(R.id.editTextEmail);
        reset_button = findViewById(R.id.btn_reset);
        //Getting Firebase Instance
        auth = FirebaseAuth.getInstance();

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etemail.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Enter your registred email", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(ForgotpasswordActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgotpasswordActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
