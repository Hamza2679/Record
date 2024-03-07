package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;


public class splash_activity extends AppCompatActivity {
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar=findViewById(R.id.progressBar);
        final Context context=this;
        Thread timeThread=new Thread(){
            public void run(){
                try{sleep(4000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();}
                finally {
                    // setupWords(context);
                    finish();
                    Intent intent=new Intent(context,SignUpActivity.class);
                    startActivity(intent);
                }
            }
        };timeThread.start();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });thread.start();
    }

}