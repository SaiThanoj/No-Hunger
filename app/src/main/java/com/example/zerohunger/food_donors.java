package com.example.zerohunger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class food_donors extends AppCompatActivity {
    ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_donors);

        ListView list_of_donors = findViewById(R.id.list_of_donors);
        notes.add("Example Note1");
        notes.add("Example Note2");
        notes.add("Example Note3");
        notes.add("Example Note4");
        notes.add("Example Note5");
        notes.add("Example Note6");
        notes.add("Example Note7");
        notes.add("Example Note8");
        notes.add("Example Note9");
        notes.add("Example Note10");
        notes.add("Example Note11");
        notes.add("Example Note12");
        notes.add("Example Note13");
        notes.add("Example Note14");
        notes.add("Example Note15");
        notes.add("Example Note16");
        notes.add("Example Note17");
        notes.add("Example Note18");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,notes);
        list_of_donors.setAdapter(arrayAdapter);

        list_of_donors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ListActivity1.class);
                intent.putExtra("noteId",i);
                startActivity(intent);
            }
        });
    }
}