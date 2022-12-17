package com.example.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Reciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String actionString = intent.getAction();
        Toast.makeText(context, actionString, Toast.LENGTH_SHORT).show();
    }
}
