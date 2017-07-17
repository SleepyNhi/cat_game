package com.example.sleepynhi.cat_game.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.sleepynhi.cat_game.service.TestService;

/**
 * Created by Sleepynhi on 7/5/17.
 */

public class TestAudioController {
    public final static int AUDIOPlaying = 111;
    public final static int AUDIOLoading = 222;
    public final static int AUDIOPause = 333;
    public static int STATUS = AUDIOPause;
    private Context context;
    private static TestAudioReceiver testAudioReceiver;
    private AudioListener listener;


    public TestAudioController(Context context, AudioListener listener) {
        this.context = context;
        this.listener = listener;
    }
    public void play(String url){
        Intent intent = new Intent(context, TestService.class);
        intent.setAction("AUDIO");
        intent.putExtra("CMD",TestService.PLAY);
        intent.putExtra("URL",url);
        context.startService(intent);
        initReceiver();
    }

    private void initReceiver() {
        testAudioReceiver = new TestAudioReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TestService.AUDIO);
        context.registerReceiver(testAudioReceiver,filter);
    }

    public void pause() {
        Intent intent = new Intent(context, TestService.class);
        intent.setAction("AUDIO");
        intent.putExtra("CMD",TestService.PAUSE);
        context.startService(intent);
        initReceiver();
    }

    public interface AudioListener{
        public void onPlaying();
        public void onLoading();
        public void onPaused();

    }


    public class TestAudioReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(TestService.AUDIO)) {
                int msg = intent.getIntExtra("MSG",0);
                switch (msg){
                    case TestService.PLAYING:
                        STATUS = AUDIOPlaying;
                        listener.onPlaying();
                        break;
                    case TestService.LOADING:
                        STATUS = AUDIOLoading;
                        listener.onLoading();
                        break;
                    case TestService.PAUSED:
                        STATUS = AUDIOPause;
                        listener.onPaused();
                        break;
                }
            }
        }
    }
}
