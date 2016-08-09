package com.example.owlslubic.hotify.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.owlslubic.hotify.MainActivity;
import com.example.owlslubic.hotify.R;

import java.io.IOException;

/**
 * Created by owlslubic on 8/8/16.
 */
public class MusicService extends Service {
    private static final String TAG = "MusicService";
    public static MediaPlayer mPlayer = new MediaPlayer();
    HandlerThread mHandlerThread;
    Handler mHandler;
    private static final String SONG_URL = "http://www.singing-bell.com/wp-content/uploads/2015/02/Mexican-Hat-Dance-Singing-Bell.mp3";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mPlayer = null;
//
//        mHandlerThread = new HandlerThread("thread");
//        mHandlerThread.start();
//        Looper looper = mHandlerThread.getLooper();
//
//        mHandler = new Handler(looper) {
//
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

//
//                if (!mPlayer.isPlaying()) {
//                    try {
//                        mPlayer.setDataSource(SONG_URL);
//                        Log.i(TAG, "handleMessage: set data source");
//                        mPlayer.prepare();
//                        mPlayer.start();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }


    }

    ;





    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       if(mPlayer == null) {
           mPlayer = new MediaPlayer();
           mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

           try {
               mPlayer.setDataSource(SONG_URL);
               mPlayer.prepare();
           } catch (IOException e) {
               e.printStackTrace();
           }


           mPlayer.start();
       } else {
            //   mPlayer.pause();
           playSong();
           }
         //  Message msg = mHandler.obtainMessage();


           Log.i(TAG, "onStartCommand: handler obtained message");
        //   mHandler.sendMessage(msg);

        return START_NOT_STICKY;

    }


    public static void playSong(){
        if(!mPlayer.isPlaying())
        mPlayer.start();
    }

    public static void pauseSong() {
        mPlayer.pause();
    }

    public static void stopSong() {
        mPlayer.stop();
    }


    //not sure about this part
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }
}


