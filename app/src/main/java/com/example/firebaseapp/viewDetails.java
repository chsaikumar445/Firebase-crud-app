package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewDetails extends AppCompatActivity {
    private DatabaseReference db;
    private ListView listView;
    private ArrayList<String> list;
    private ArrayAdapter<String> arrayAdapter;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        db = FirebaseDatabase.getInstance().getReference("Students");


        listView = findViewById(R.id.list_view);
        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    String key = data.getKey();
                    Student ob = data.getValue(Student.class);
                    String values = "Name: " + ob.getName() + " id: " + ob.getId()+" salary "+ob.getSalary()+" phone "+ob.getPhone()+" email "+ob.getEmail()+" location "+ob.getLocation();
                    Log.v("values ", values);
                    Toast.makeText(getApplicationContext(),"data added successfully",Toast.LENGTH_SHORT).show();
                     list.add(values);
                }
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"data failed",Toast.LENGTH_SHORT).show();
            }
        });


    }
}