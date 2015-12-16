package com.example.pjust.webcap8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg = (TextView) findViewById(R.id.tv_msg);

        verifyConnectionType();
        //verifyConnection();

    }

    private void verifyConnectionType(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        String s = "Connection: ";

        if(wifi.isConnected()){
            s+= "Wi-fi";
        }else if(mobile.isConnected()){
            s += "Mobile";
        }else{
            s += "None";
        }

        tvMsg.setText(s);
    }

    private void verifyConnection(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        String s = "Connection: ";

        if(info != null && info.isConnected()){
            s += "Connected";
        }else{
            s += "Not Connected";
        }

    }
}
