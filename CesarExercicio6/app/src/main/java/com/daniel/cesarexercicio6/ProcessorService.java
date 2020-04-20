package com.daniel.cesarexercicio6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.LinkedList;

public class ProcessorService extends Service {

    private static final String TAG = ProcessorService.class.getSimpleName();

    private final IBinder binder = new LocalBinder();

    private LinkedList<String> list = new LinkedList<String>();

    public class LocalBinder extends Binder {
        ProcessorService getService() {
            return (ProcessorService.this);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
        list = new LinkedList<String>();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        //filter(this.list);

        //return START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

    public LinkedList<String> filter(LinkedList<String> lst) {
        Log.i(TAG, "Enter in Processing");

        for (int i = 0; i < lst.size(); i++) {
            String temp = lst.get(i);
            for (int j = i + 1; j < lst.size(); j++) {
                String temp2 = lst.get(j);
                if (temp.equals(temp2)) {
                    lst.remove(j);
                    j--;
                }
            }
        }
        return lst;
    }

    public LinkedList<String> getList() {
        return this.list;
    }

    public void setList(LinkedList<String> lst) {
        Log.i("service", "setList: ");
        this.list = lst;
    }
}
