package com.example.owlslubic.hotify.services;

import android.app.Service;
import android.content.Intent;
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

/**
 * Created by owlslubic on 8/8/16.
 */
public class MusicService extends Service {
    private static final String TAG = "MusicService" ;
    private HandlerThread mHandlerThread;
    private Handler mHandler;
    private MediaPlayer mPlayer = null;
    private static final String ACTION_PLAY = "com.example.owlslubic.hotify.action.PLAY";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lo_dudo);



        
//        mHandlerThread = new HandlerThread("Music Player Thread");
//        mHandlerThread.start();
//        Looper looper = mHandlerThread.getLooper();
//
//        mHandler = new Handler(looper){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                Log.i(TAG, "handleMessage: The Handler is doing somethin'");
//
////                String mediaPlayback = (String) msg.obj;
////                switch (mediaPlayback){
////                    case "play":
////                        mPlayer.start();
////                        Log.i(TAG, "onStartCommand: player plays");
////                        break;
////                    case "pause":
////                        mPlayer.pause();
////                        Log.i(TAG, "onStartCommand: player paused");
////                        break;
////                    case "stop":
////                        mPlayer.stop();
////                        Log.i(TAG, "onStartCommand: player stopped");
////                        break;
////                    default:
////                        mPlayer.pause();
////                }
//            }
//        };

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Message msg = mHandler.obtainMessage();
        Log.i(TAG, "onStartCommand: handler obtained message");
        msg.obj = intent.getStringExtra(MainActivity.PLAYBACK_KEY);
        mHandler.sendMessage(msg);
        String mediaPlayback = (String) msg.obj;
        switch (mediaPlayback){
            case "play":
                mPlayer.start();
                Log.i(TAG, "onStartCommand: player plays");
                break;
            case "pause":
                mPlayer.pause();
                Log.i(TAG, "onStartCommand: player paused");
                break;
            case "stop":
                mPlayer.stop();
                Log.i(TAG, "onStartCommand: player stopped");
                break;
            default:
                mPlayer.start();
        }


    return START_STICKY;

    }


}
