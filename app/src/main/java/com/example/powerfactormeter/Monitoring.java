package com.example.powerfactormeter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Monitoring extends AppCompatActivity {
    TextView pi, cospi;
    String ValPI, ValCOSPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        pi = findViewById(R.id.pi);
        cospi = findViewById(R.id.cospi);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ValPI = dataSnapshot.child("pi").getValue().toString();
                ValCOSPI = dataSnapshot.child("cospi").getValue().toString();
                pi.setText("" + ValPI);
                cospi.setText("" + ValCOSPI);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }
}