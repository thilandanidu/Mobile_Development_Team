package com.example.activityresultlauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.activityresultlauncher.LauncherOne.LauncherOneMain;
import com.example.activityresultlauncher.LauncherTwo.LauncherTwoMain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mainBtn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LauncherOneMain.class);
                startActivity(i);
            }
        });
        findViewById(R.id.mainBtn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LauncherTwoMain.class);
                startActivity(i);
            }
        });
    }
}