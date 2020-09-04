package com.example.zerohungerlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {
TextView notifications,help,invitefriend;
CardView cardView2,cardView3,cardView4;
Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        notifications = findViewById(R.id.notiTextView);
        help = findViewById(R.id.helpTextView);
        invitefriend = findViewById(R.id.inviteFriendTextView);
        cardView2 = findViewById(R.id.cardview2);
        cardView3 = findViewById(R.id.cardview3);
        cardView4 = findViewById(R.id.cardview4);



    }
}