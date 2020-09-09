package com.example.zerohungerlogin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class money_spentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView_money_spent;
    private money_spentAdapter adapter_money_spent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_spent_list);

        recyclerView_money_spent = findViewById(R.id.recycler_money_spent);
        recyclerView_money_spent.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<money_spent> options =
                new FirebaseRecyclerOptions.Builder<money_spent>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("money_spent"), money_spent.class)
                        .build();

        adapter_money_spent = new money_spentAdapter(options);
        recyclerView_money_spent.setAdapter(adapter_money_spent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter_money_spent.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter_money_spent.stopListening();
    }
}