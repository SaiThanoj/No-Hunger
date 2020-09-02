package com.example.zerohungerlogin;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class OptionsMenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.ok, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"You clicked Settings!!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Wait for sharing....",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String sharebody = "ok this is the body";
                String sharesub = "this is the subject";
                intent.putExtra(Intent.EXTRA_TEXT,sharebody);
                intent.putExtra(Intent.EXTRA_TEXT,sharesub);
                startActivity(Intent.createChooser(intent,"ShareVia"));
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"You clicked About us!!",Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(StartActivity.this,AboutActivity.class));
                return true;
            case R.id.item4:
                Toast.makeText(getApplicationContext(),"You clicked Sign out....",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
