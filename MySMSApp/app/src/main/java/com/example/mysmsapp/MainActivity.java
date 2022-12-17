package com.example.mysmsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText message, number;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.numberEditText);
        message = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMS();
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if(checkSelfPermission(android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendSMS();
                    } else {
                        requestPermissions(new String[] {android.Manifest.permission.SEND_SMS}, 1);
                    }
                }
            }
        });

    }

    private void sendSMS() {
//        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + number.getText().toString()));
//        smsIntent.putExtra("sms body", message.getText().toString());
//        startActivity(smsIntent);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number.getText().toString(), null, message.getText().toString(), null, null);
    }
}