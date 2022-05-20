package com.example.smsforwardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String stringNumber = "+94711261361";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);

        textView = findViewById(R.id.textView);
    }

    public void buttonForward(View view){
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"),null, null, null, null);
        cursor.moveToFirst();

        cursor.moveToFirst();

        while (cursor != null){
            String stringMessage = cursor.getString(12);

            if(stringMessage.contains("AC-Challenge")){
                SmsManager smsManagerSend = SmsManager.getDefault();
                smsManagerSend.sendTextMessage(stringNumber, null, stringMessage, null, null);

                textView.setText("Message Sent");
//                break;
            }
            textView.setText("message NOT found");

            cursor.moveToNext();
        }
    }

}