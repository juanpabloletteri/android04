package com.example.alumno.android04;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        MiHilo m = new MiHilo(handler);
        m.start();


    }


    @Override
    public boolean handleMessage(Message msg) {
        Log.d("mensaje main", msg.obj.toString());
        return false;
    }
}
