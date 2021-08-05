package com.prabhakar.threads_we;


import android.os.Handler;
import android.os.Looper;

public class ThreadManager extends Thread {
    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler();
        Looper.loop();
    }

    public void addTaskToQueue(Runnable task) {
        if (handler != null) {
            handler.post(task);
        }
    }
}
