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

import java.util.HashMap;

public class updateSalary extends AppCompatActivity {

    private DatabaseReference db;
    private TextInputLayout idLayout;
    private Button update;
    private TextInputLayout salaryLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_salary);

        update=findViewById(R.id.update_button);
        idLayout=findViewById(R.id.textInputLayout);
        salaryLayout=findViewById(R.id.textInputLayout2);
        db= FirebaseDatabase.getInstance().getReference("Students");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idLayout.getEditText().getText().toString();
                String salary=salaryLayout.getEditText().getText().toString();
                if(!id.isEmpty()){
                    Query applesQuery = db.orderByChild("id").equalTo(id);
                    applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                Student ob=appleSnapshot.getValue(Student.class);
                                HashMap map = new HashMap();
                                map.put("salary",salary);
                                try{
                                    if(db.child(String.valueOf(id))!=null) {
                                        db.child(String.valueOf(id)).updateChildren(map);
                                        Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
                                    }
                                    else
                                        Toast.makeText(getApplicationContext(), "Data Not Available", Toast.LENGTH_LONG).show();
                                }catch(Exception e){
                                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                                }

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