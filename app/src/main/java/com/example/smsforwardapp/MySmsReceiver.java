package com.example.smsforwardapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class MySmsReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"),null, null, null, null);
        // you can't use getContentResolver() directly outside main activity class. but you can do it by using it as context.getContentResolver.


    }
}
