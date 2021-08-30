package com.example.activityresultlauncher.LauncherOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.activityresultlauncher.R;

public class SendBackTextActivity extends AppCompatActivity {

    EditText Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_back_text);


        Message = findViewById(R.id.txt_messagel);
    }

    // Send the result to Parent activity
    public void sendMessage(View view)
    {
        // get the message from the user
        String message = Message.getText().toString();


        // adjust the data to an intent object
        Intent intent = new Intent();
        // attach the message to returnIntent, ( specify the key for intent data, specify the data)
        intent.putExtra("message", message);

        // to send out the message to parent activity, use method 'setResult' (result code , intent object)
        /*
        if the child activity successfully process the request and if the response is okay, then pass result code as 'RESULT_OK'
        if the child activity failed to process the request, then pass result code as 'RESULT_CANCELED'
         */
        setResult(555, intent);
        // finish the activity
        finish();
    }
}