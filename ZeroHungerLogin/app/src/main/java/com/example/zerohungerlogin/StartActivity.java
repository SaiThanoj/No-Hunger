package com.example.zerohungerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        FirebaseUser firebaseuser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseuser == null) {
            startActivity(new Intent(StartActivity.this, MainActivity.class));
            finish();
        }
    }
}