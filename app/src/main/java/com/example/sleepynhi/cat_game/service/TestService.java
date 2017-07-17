package com.example.sleepynhi.cat_game.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sleepynhi on 7/3/17.
 */

public class TestService extends Service {
    public static final int LOADING = 11111;
    public static final int PLAYING = 22222;
    public static final int PAUSED = 33333;
    public static final int PLAY = 55555;
    public static final int PAUSE = 66666;


    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Timer timer = new Timer();
    private int update = 0;
    public static final String UPDATE = "update";
    public static final String ACTION = "TestAction";
    public static final String AUDIO = "AUDIO";
    private String url="";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(intent.getAction().equals("AUDIO")){
            if(intent.getIntExtra("CMD",0) == PLAY){
                String urlMsg = intent.getStringExtra("URL");
                if (url.equals(urlMsg)){
                    mediaPlayer.start();
                    sendPlaying();
                }else {
                    try {
                        url = urlMsg;
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.prepareAsync();
                        sendLoading();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else if (intent.getIntExtra("CMD",0) == PAUSE){
                mediaPlayer.pause();
                sendPaused();
            }

        } else {
            String value = intent.getStringExtra("Service");
            if (value.equals("Start")) {
                timer.schedule(new UpdateTask(), 0, 1000);
            } else if (value.equals("Stop")) {
                timer.cancel();
            }
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                sendPlaying();
            }
        });

        return super.onStartCommand(intent, flags, startId);

    }

    private void sendPaused() {
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG",PAUSED);
        sendBroadcast(intent);
    }

    private void sendPlaying(){
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG",PLAYING);
        sendBroadcast(intent);
    }

    private void sendLoading(){
        Intent intent = new Intent();
        intent.setAction(AUDIO);
        intent.putExtra("MSG",LOADING);
        sendBroadcast(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class UpdateTask extends TimerTask {
        public void run(){
            Intent intent = new Intent();
            intent.setAction(ACTION); //necessary
            intent.putExtra(UPDATE,++update);
            sendBroadcast(intent);

        }
    }
}
