package com.example.activityresultlauncher.LauncherTwo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.activityresultlauncher.R;

public class PrintLogcatBtnTwo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_logcat_btn_two);


        //
        findViewById(R.id.l2MsgTwoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent();
                intent.putExtra("lazyday", "iOS Developer");
                //
                setResult(222, intent);
                //
                finish();
            }
        });
    }
}