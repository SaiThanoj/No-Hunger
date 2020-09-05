package com.example.zerohungerlogin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DonateFoodActivity extends AppCompatActivity {

    private EditText name;
    private EditText address;
    private EditText pin;
    private EditText ph;
    private EditText rice;
    private EditText curry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_food);

        Button add = findViewById(R.id.button);
        name = findViewById(R.id.editText);
        address = findViewById(R.id.editTextTextMultiLine2);
        pin = findViewById(R.id.editTextTextPostalAddress);
        ph = findViewById(R.id.editTextPhone);
        rice = findViewById(R.id.editTextNumber);
        curry = findViewById(R.id.editTextNumber3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> map = new HashMap<>();
                map.put("name",name.getText().toString());
                map.put("address",address.getText().toString());
                map.put("pin",pin.getText().toString());
                map.put("ph",ph.getText().toString());
                map.put("rice",rice.getText().toString());
                map.put("curry",curry.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("food_donors").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("yep","onComplete: ");
                                //Toast.makeText(getApplicationContext(),"ADDED", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("nope","OnFailure: "+e.toString());
                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i("yep","onComplete: ");
                    }
                });
            }
        });
    }
}