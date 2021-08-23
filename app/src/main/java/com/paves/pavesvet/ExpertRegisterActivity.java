package com.paves.pavesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ExpertRegisterActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText fullName, your_location, mobileNumber, area_specialized, emailAddress, kvbNumber, password;
    private FirebaseAuth  firebaseAuth;
    TextView already_registered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_register);

        fullName = findViewById(R.id.editTextName);
        your_location = findViewById(R.id.editTextLoaction);
        mobileNumber = findViewById(R.id.editTextMobile);
        area_specialized = findViewById(R.id.editTextExpertise);
        emailAddress = findViewById(R.id.editTextEmail);
        kvbNumber = findViewById(R.id.editTextKvb);
        password = findViewById(R.id.editTextPassword);
        already_registered = findViewById(R.id.textViewLogin);
        firebaseAuth = FirebaseAuth.getInstance();

        //When expert is already registered
        already_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertRegisterActivity.this, ExpertLoginActivity.class));
                finish();
            }
        });
    }

        // To check if expert has active session
        @Override
        protected void onStart() {
            super.onStart();
            if (firebaseAuth.getCurrentUser() != null) {
                startActivity(new Intent(ExpertRegisterActivity.this, ExpertDashboardActivity.class));
                finish();
            }
            findViewById(R.id.buttonRegister).setOnClickListener(this);
        }


        private void registerExpert() {

            final String full_name = fullName.getText().toString().trim();
            final String location = your_location.getText().toString().trim();
            final String mobile_number = mobileNumber.getText().toString().trim();
            final String expertise = area_specialized.getText().toString().trim();
            final String email_address = emailAddress.getText().toString().trim();
            final String kvb_number = kvbNumber.getText().toString().trim();
            String user_password = password.getText().toString().trim();

            if (full_name.isEmpty()) {
                fullName.setError("your name required");
                fullName.requestFocus();

            } else if (location.isEmpty()) {
                your_location.setError("location required");
                your_location.requestFocus();

            } else if (mobile_number.isEmpty()) {
                mobileNumber.setError("mobile number is required");
                mobileNumber.requestFocus();

            } else if (!Patterns.PHONE.matcher(mobile_number).matches()) {
                mobileNumber.setError("Enter valid mobile number");
                mobileNumber.requestFocus();

            }
            else if (expertise.isEmpty()){
                kvbNumber.setError("KVB number is required");
                kvbNumber.requestFocus();
            }
            else if (kvb_number.isEmpty()){
                area_specialized.setError("KVB number is required");
                area_specialized.requestFocus();
            }
            else if (email_address.isEmpty()) {
                emailAddress.setError("first name required");
                emailAddress.requestFocus();

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email_address).matches()) {
                emailAddress.setError("Enter valid email address");
                emailAddress.requestFocus();

            } else if (user_password.isEmpty()) {
                password.setError("first name required");
                password.requestFocus();

            } else if (user_password.length() < 6) {
                password.setError("Password too short, enter minimum 6 characters!");


            } else{
                //create user
                firebaseAuth.createUserWithEmailAndPassword(email_address, user_password)
                        .addOnCompleteListener(ExpertRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(ExpertRegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_LONG).show();

                                if (task.isSuccessful()) {
                                    Expert myExpert = new Expert(
                                            full_name,
                                            location,
                                            mobile_number,
                                            expertise,
                                            email_address,
                                            kvb_number
                                    );
                                    FirebaseDatabase.getInstance().getReference("experts")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(myExpert).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                Toast.makeText(ExpertRegisterActivity.this,
                                                        "Registration was successful", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(ExpertRegisterActivity.this,
                                                        ExpertDashboardActivity.class);
                                                startActivity(intent);
                                            }
                                        }
                                    });
                                } else {
                                    Toast.makeText(ExpertRegisterActivity.this, "Authentication failed." + task.getException().getMessage(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }

        }//closing private class register farmer


        @Override
        public void onClick(View v){
            if (v.getId() == R.id.buttonRegister) {
                registerExpert();
            }
        }
    }//closing public class ExpertRegisterActivity


