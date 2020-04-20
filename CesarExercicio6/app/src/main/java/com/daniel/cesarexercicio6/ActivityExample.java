package com.daniel.cesarexercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.util.LinkedList;

public class ActivityExample extends AppCompatActivity {

    private LinkedList<String> list = new LinkedList<String>();

    ProcessorService mProcessor;
    boolean mBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        createLinky(list);

        Intent it = new Intent("PROCESSOR_SERVICE");
        it.setPackage("com.daniel.cesarexercicio6");
        bindService(it, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mBound = false;
    }

    public void createLinky(LinkedList<String> list) {
        list.add("danguto@gmail.com");
        list.add("joeli.bastos@gmail.com");
        list.add("daniel.souza@gmail.com");
        list.add("daniel.augusto@gmail.com");
        list.add("daniel.souza@gmail.com");
        list.add("daniel.souza@gmail.com");
        list.add("daniel.souza@gmail.com");
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ProcessorService.LocalBinder binder = (ProcessorService.LocalBinder) service;
            mProcessor = binder.getService();
            mBound = true;
            mProcessor.setList(list);
            Log.i("Teste", list.toString()); //before processing
            mProcessor.filter(list);
            Log.i("Teste", list.toString()); //after processing
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };
}
