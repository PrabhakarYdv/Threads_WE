package com.prabhakar.threads_we;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button buttonTask1, buttonTask2;
    private ThreadManager threadManager;

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTask1 = findViewById(R.id.btn_task1);
        buttonTask2 = findViewById(R.id.btn_task2);
        threadManager = new ThreadManager();
        threadManager.start();


        buttonTask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadManager.addTaskToQueue(taskOne);
            }
        });

        buttonTask2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadManager.addTaskToQueue(taskTwo);
            }
        });
    }

    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Task 1 : "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task 2 : "+ Thread.currentThread().getName());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}