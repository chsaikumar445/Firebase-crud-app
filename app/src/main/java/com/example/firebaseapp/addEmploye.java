package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addEmploye extends AppCompatActivity {

    private DatabaseReference db;
    private TextInputLayout nameLayout;
    private TextInputLayout idLayout;
    private TextInputLayout salaryLayout;
    private TextInputLayout phoneLayout;
    private TextInputLayout emailLayout;
    private TextInputLayout locationLayout;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employe);

        nameLayout=findViewById(R.id.textInputLayout);
        idLayout=findViewById(R.id.textInputLayout2);
        salaryLayout=findViewById(R.id.textInputLayout3);
        phoneLayout=findViewById(R.id.textInputLayout4);
        emailLayout=findViewById(R.id.textInputLayout5);
        locationLayout=findViewById(R.id.textInputLayout6);
        save=findViewById(R.id.save_button);

        db= FirebaseDatabase.getInstance().getReference("Students");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameLayout.getEditText().getText().toString();
                String id=idLayout.getEditText().getText().toString();
                String salary=salaryLayout.getEditText().getText().toString();
                String phone=phoneLayout.getEditText().getText().toString();
                String email=emailLayout.getEditText().getText().toString();
                String location=locationLayout.getEditText().getText().toString();

                Student obj=new Student(name,id,salary,phone,email,location);
                try {
                    db.child(id).setValue(obj);
                }catch (Exception e){

                }

            }
        });

    }

}