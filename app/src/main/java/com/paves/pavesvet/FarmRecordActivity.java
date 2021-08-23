package com.paves.pavesvet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.paves.pavesvet.model.FarmRecord;

public class FarmRecordActivity extends AppCompatActivity {
    Button submitButton;
    EditText livestockIncome, cropIncome, otherIncome, totalIncome, livestockExpense, cropExpense, otherExpense, totalExpense;
    DatabaseReference databaseReference;
    FarmRecord farmRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_record);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DiagnosisActivity.class));
            }
        });



        livestockIncome = findViewById(R.id.livestock_income_amount);
        cropIncome = findViewById(R.id.crop_income_amount);
        otherIncome = findViewById(R.id.other_income_amount);
        totalIncome = findViewById(R.id.total_income_amount);
        livestockExpense = findViewById(R.id.livestock_expense_amount);
        cropExpense = findViewById(R.id.crop_expense_amount);
        otherExpense = findViewById(R.id.other_expense_amount);
        totalExpense = findViewById(R.id.total_expense_amount);
        submitButton = findViewById(R.id.add_data);
        farmRecord = new FarmRecord();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("farm_record");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String livestock_incomes = livestockIncome.getText().toString().trim();
                String crop_incomes = cropIncome.getText().toString().trim();
                String other_incomes = otherIncome.getText().toString().trim();
                String total_incomes = totalIncome.getText().toString().trim();
                String livestock_expenses = livestockExpense.getText().toString().trim();
                String crop_expenses = cropExpense.getText().toString().trim();
                String other_expenses = otherExpense.getText().toString().trim();
                String total_expenses = totalExpense.getText().toString().trim();


                if (livestock_incomes.isEmpty()) {
                    livestockIncome.setError("livestock income required");
                    livestockIncome.requestFocus();

                } else if (crop_incomes.isEmpty()) {
                    cropIncome.setError("crop income required");
                    cropIncome.requestFocus();

                } else if (other_incomes.isEmpty()) {
                    otherIncome.setError("other income required");
                    otherIncome.requestFocus();

                }else if (total_incomes.isEmpty()){
                    totalIncome.setError("total income required");
                    totalIncome.requestFocus();
                }
                else if (livestock_expenses.isEmpty()){
                    livestockExpense.setError("livestock expense required");
                    livestockExpense.requestFocus();
                }
                else if (crop_expenses.isEmpty()) {
                    cropExpense.setError("crop expense required");
                    cropExpense.requestFocus();
                } else if (other_expenses.isEmpty()) {
                    otherExpense.setError("other expenses required");
                    otherExpense.requestFocus();
            } else if (total_expenses.isEmpty()) {
                totalExpense.setError("total expenses required");
                totalExpense.requestFocus();

            } else{

                farmRecord.setLivestock_income(livestock_incomes);
                farmRecord.setCrop_income(crop_incomes);
                farmRecord.setOther_income(other_incomes);
                farmRecord.setTotal_income(total_incomes);
                farmRecord.setLivestock_expense(livestock_expenses);
                farmRecord.setCrop_expense(crop_expenses);
                farmRecord.setOther_espense(other_expenses);
                farmRecord.setTotal_expense(total_expenses);

                databaseReference.push().setValue(farmRecord);
                Toast.makeText(FarmRecordActivity.this, "Record Added Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FarmRecordActivity.this, DiagnosisActivity.class);
                startActivity(intent);
                }

            }
        });
    }

}


