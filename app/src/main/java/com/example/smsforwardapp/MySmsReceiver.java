package com.example.smsforwardapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    private TextView textView;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Thilina Got the sms",Toast.LENGTH_SHORT).show();

        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null,null, null, "date desc limit 1");
        // you can't use getContentResolver() directly outside main activity class. but you can do it by using it as context.getContentResolver.



    }
}
