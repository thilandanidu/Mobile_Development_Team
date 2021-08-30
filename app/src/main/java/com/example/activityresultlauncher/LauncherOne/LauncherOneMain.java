package com.example.activityresultlauncher.LauncherOne;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activityresultlauncher.R;

public class LauncherOneMain extends AppCompatActivity {

    private TextView TxtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_one_main);

        TxtDisplay = findViewById(R.id.txt_display_message);
    }


    //
    public void getMessage(View view) {
        Intent intent = new Intent(LauncherOneMain.this, SendBackTextActivity.class);
        someActivityResultLauncher.launch(intent);
    }


    //
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == 555) {
                    // There are no request codes
                    Intent data = result.getData();
                    String message = data.getStringExtra("message");
                    // display the message using TextView
                    TxtDisplay.setText(message);
                }
            });

}