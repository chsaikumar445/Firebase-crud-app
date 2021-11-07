package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button view;
    private Button add;
    private Button delete;
    private Button search;
    private Button update;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=findViewById(R.id.view_button);
        add=findViewById(R.id.add_button);
        search=findViewById(R.id.search_button);
        delete=findViewById(R.id.delete_button);
        update=findViewById(R.id.update_button);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,viewDetails.class);
                startActivity(i);
            }

        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, addEmploye.class);
                startActivity(j);

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(MainActivity.this,searchEmployee.class);
                startActivity(k);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(MainActivity.this,deleteEmployee.class);
                startActivity(l);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(MainActivity.this,updateSalary.class);
                startActivity(m);
            }
        });




}
}