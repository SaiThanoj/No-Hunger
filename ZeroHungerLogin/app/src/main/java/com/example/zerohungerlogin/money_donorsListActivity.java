package com.example.zerohungerlogin;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class money_donorsListActivity extends AppCompatActivity {
    private money_donorsAdapter adapter_money_donors;
    private RecyclerView recyclerView_money_donors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_donors_list);
        //setContentView(R.layout.activity_main);

        recyclerView_money_donors = findViewById(R.id.recycler_money_donors);
        recyclerView_money_donors.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<money_donors> options =
                new FirebaseRecyclerOptions.Builder<money_donors>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("money_donors"), money_donors.class)
                        .build();
        adapter_money_donors = new money_donorsAdapter(options);
        recyclerView_money_donors.setAdapter(adapter_money_donors);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter_money_donors.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter_money_donors.stopListening();
    }

}