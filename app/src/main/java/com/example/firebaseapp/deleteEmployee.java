package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class deleteEmployee extends AppCompatActivity {

    private Button delete;
    private TextInputLayout idnoLayout;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);

        db= FirebaseDatabase.getInstance().getReference("Students");
        delete=findViewById(R.id.delete_button);
        idnoLayout=findViewById(R.id.textInputLayout);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idnoLayout.getEditText().getText().toString();
                if(!id.isEmpty()){
                    Query applesQuery = db.orderByChild("id").equalTo(id);

                    applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                appleSnapshot.getRef().removeValue();
                                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(getApplicationContext(),"deletion failed",Toast.LENGTH_SHORT).show();
                            Log.e("Failed", "onCancelled", databaseError.toException());
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter The Id",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}