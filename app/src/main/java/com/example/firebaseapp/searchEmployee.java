package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class searchEmployee extends AppCompatActivity {

    private Button delete;
    private TextInputLayout idnoLayout;
    private DatabaseReference db;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        db= FirebaseDatabase.getInstance().getReference("Students");
        delete=findViewById(R.id.delete_button);
        idnoLayout=findViewById(R.id.textInputLayout);
        text=findViewById(R.id.Text_view);

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
                                Student ob=appleSnapshot.getValue(Student.class);
                                String values = "Name: " + ob.getName() + " id: " + ob.getId()+" salary "+ob.getSalary()+" phone "+ob.getPhone()+" email "+ob.getEmail()+" location "+ob.getLocation();
                                text.setText(values);
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
