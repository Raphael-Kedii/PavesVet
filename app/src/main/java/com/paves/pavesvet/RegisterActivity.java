package com.paves.pavesvet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

   private EditText fname, lname, mobile_number, email_address, password;
   TextView already_registered;
   private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //databaseReference = FirebaseDatabase.getInstance().getReference("farmers");
        fname = findViewById(R.id.editText3);
        lname = findViewById(R.id.editText4);
        mobile_number = findViewById(R.id.editText5);
        email_address = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        already_registered = findViewById(R.id.textView3);

        auth = FirebaseAuth.getInstance();

        //When farmer is already registered
        already_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
// To check if farmer has active session
    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
            finish();
        }
        findViewById(R.id.button2).setOnClickListener(this);
    }


    private void registerFarmer() {

        final String first_name = fname.getText().toString().trim();
        final String last_name = lname.getText().toString().trim();
        final String number = mobile_number.getText().toString().trim();
        final String email = email_address.getText().toString().trim();
        String user_password = password.getText().toString().trim();

        if (first_name.isEmpty()) {
            fname.setError("first name required");
            fname.requestFocus();

        } else if (last_name.isEmpty()) {
            lname.setError("last name required");
            lname.requestFocus();

        } else if (number.isEmpty()) {
            mobile_number.setError("mobile number is required");
            mobile_number.requestFocus();

        } else if (!Patterns.PHONE.matcher(number).matches()) {
            mobile_number.setError("Enter valid mobile number");
            mobile_number.requestFocus();

        } else if (email.isEmpty()) {
            email_address.setError("first name required");
            email_address.requestFocus();

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_address.setError("Enter valid email address");
            email_address.requestFocus();

        } else if (user_password.isEmpty()) {
            password.setError("first name required");
            password.requestFocus();

        } else if (user_password.length() < 6) {
            password.setError("Password too short, enter minimum 6 characters!");


        } else{
        //create user
        auth.createUserWithEmailAndPassword(email, user_password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_LONG).show();

                        if (task.isSuccessful()) {
                            Farmer myFarmer = new Farmer(
                                    first_name,
                                    last_name,
                                    number,
                                    email
                            );
                            FirebaseDatabase.getInstance().getReference("farmers")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(myFarmer).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Registration was successful", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    }//closing private class register farmer


@Override
    public void onClick(View v){
    if (v.getId() == R.id.button2) {
        registerFarmer();
    }
    }
}//clossing public class RegisterActivity
