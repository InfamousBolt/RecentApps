package com.example.recentapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Try","created");
        setContentView(R.layout.activity_main);
        IntentFilter intentFilterACSD = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                    //do what you want here
                    Log.d("Try", "Pressed home or recent apps");
                    finish();

                }
            }
        };
        this.registerReceiver(broadcastReceiver, intentFilterACSD);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(broadcastReceiver);
    }
}