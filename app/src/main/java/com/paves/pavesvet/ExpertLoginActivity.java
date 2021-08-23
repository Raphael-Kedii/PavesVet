package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ExpertLoginActivity extends AppCompatActivity {
    EditText et_email,et_password;
    Button btn_login;
    TextView tv_register, tv_forgot_password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Firebase auth Instance
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!= null){
            startActivity(new Intent(ExpertLoginActivity.this, ExpertDashboardActivity.class));
            finish();
        }
        //Setting the view
        setContentView(R.layout.activity_expert_login);

        et_email = findViewById(R.id.editTextEmailAddress);
        et_password = findViewById(R.id.editTextPassword);
        btn_login = findViewById(R.id.buttonLogin);
        tv_forgot_password = findViewById(R.id.textViewForgotPassword);
        tv_register = findViewById(R.id.textViewReg);

        //Getting Firebase Instance
        firebaseAuth = FirebaseAuth.getInstance();

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertLoginActivity.this, ExpertRegisterActivity.class));
            }
        });
        tv_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertLoginActivity.this, ForgotpasswordActivity.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                final String password = et_password.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //authenticate user
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(ExpertLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()){
                            //There is an error
                            if (password.length()<6){
                                et_password.setError(getString(R.string.minimum_password));
                            }else {
                                Toast.makeText(ExpertLoginActivity.this,getString(R.string.auth_failed),Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(ExpertLoginActivity.this, ExpertDashboardActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });

    }
}
