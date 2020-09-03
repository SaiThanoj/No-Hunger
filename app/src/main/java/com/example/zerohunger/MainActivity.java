package com.example.zerohunger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG="Mainactivity";

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    private void initView() {

        Log.d(TAG,"initView: started");
        drawer =(DrawerLayout)findViewById(R.id.drawer);
        navigationView =(NavigationView)findViewById(R.id.navigation_drawer);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.donatefood:
                Toast.makeText(getApplicationContext(),"Item 1 selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DonateFoodActivity.class);
                //intent.putExtra("noteId",i);
                startActivity(intent);

            case R.id.fooddonors:
                Toast.makeText(getApplicationContext(),"Item 2 selected",Toast.LENGTH_SHORT).show();

            case R.id.moneydonors:
                Toast.makeText(getApplicationContext(),"Item 3 selected",Toast.LENGTH_SHORT).show();

            case R.id.moneyspent:
                Toast.makeText(getApplicationContext(),"Item 4 selected",Toast.LENGTH_SHORT).show();

            case R.id.settings:
                Toast.makeText(getApplicationContext(),"Item 5 selected",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}