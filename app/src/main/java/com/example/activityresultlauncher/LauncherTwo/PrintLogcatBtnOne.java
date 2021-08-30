package com.example.activityresultlauncher.LauncherTwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.activityresultlauncher.R;

public class PrintLogcatBtnOne extends AppCompatActivity {


    Button lActivity2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_logcat_btn_one);


        lActivity2Btn = findViewById(R.id.l2MsgOneBtn);

        lActivity2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent();
                intent.putExtra("lazyday", "Android Developer");
                //
                setResult(222, intent);   //222 = 'Activity.RESULT_OK' can use this too
                //
                finish();
            }
        });
    }
}