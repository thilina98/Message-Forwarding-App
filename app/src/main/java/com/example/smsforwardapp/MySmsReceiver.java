package com.example.smsforwardapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    private TextView textView;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Thilina Got the sms",Toast.LENGTH_SHORT).show();

        TextView textView;
        String stringNumber = "+94710764814";

        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null,null, null, "date desc limit 1");
        cursor.moveToFirst();
        // you can't use getContentResolver() directly outside main activity class. but you can do it by using it as context.getContentResolver.
        String stringMessage = cursor.getString(12);
        SmsManager smsManagerSend = SmsManager.getDefault();
        smsManagerSend.sendTextMessage(stringNumber, null, stringMessage, null, null);

    }


//        private SharedPreferences preferences;
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            Toast.makeText(context,"recieved",Toast.LENGTH_SHORT).show();
//
//            if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
//                Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
//                SmsMessage[] msgs = null;
//                String msg_from;
//                if (bundle != null){
//                    //---retrieve the SMS message received---
//                    try{
//                        Object[] pdus = (Object[]) bundle.get("pdus");
//                        msgs = new SmsMessage[pdus.length];
//                        Toast.makeText(context,msgs[0].getMessageBody(),Toast.LENGTH_SHORT).show();
//                        for(int i=0; i<msgs.length; i++){
//                            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
//                            msg_from = msgs[i].getOriginatingAddress();
//                            String msgBody = msgs[i].getMessageBody();
//                        }
//                    }catch(Exception e){
////                            Log.d("Exception caught",e.getMessage());
//                    }
//                }
//            }
//        }
    }

