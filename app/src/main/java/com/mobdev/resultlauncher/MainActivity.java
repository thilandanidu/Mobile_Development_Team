package com.mobdev.resultlauncher;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView TextViewResult;
    private EditText Number1;
    private EditText Number2;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewResult = findViewById(R.id.result);
        Number1 = findViewById(R.id.number1);
        Number2 = findViewById(R.id.number2);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = getIntent();
                    int results = result.getData().getIntExtra("result", 0);
                    TextViewResult.setText("" + results);
                }
            }
        });

        Button openActivity2 = findViewById(R.id.openActivity2);
        openActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number1 = Integer.parseInt(Number1.getText().toString());
                int number2 = Integer.parseInt(Number2.getText().toString());

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("number1", number1);
                intent.putExtra("number2", number2);

                activityResultLauncher.launch(intent);
            }
        });

    }
}