package com.example.activityresultlauncher.LauncherTwo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.activityresultlauncher.LauncherOne.LauncherOneMain;
import com.example.activityresultlauncher.R;

public class LauncherTwoMain extends AppCompatActivity {

    Button lBtn1,lBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_two_main);


        lBtn1 = findViewById(R.id.launceBtn1);
        lBtn2 = findViewById(R.id.launceBtn2);

        ActivityResultLauncher<Intent> intentLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    //
                    if (result.getResultCode() == 222) {  // 222 = Activity.RESULT_OK
                        String data = result.getData().getStringExtra("lazyday");
                        Log.e("LauncherMain", data);
                    }
                    else if (result.getResultCode() == 333) {
                        String data = result.getData().getStringExtra("lazyday");
                        Log.e("LauncherMain", data);
                    }

                }
        );

        //
        lBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LauncherTwoMain.this, PrintLogcatBtnOne.class);
                intentLaunch.launch(i);
            }
        });
        lBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LauncherTwoMain.this, PrintLogcatBtnTwo.class);
                intentLaunch.launch(i);
            }
        });
    }
}