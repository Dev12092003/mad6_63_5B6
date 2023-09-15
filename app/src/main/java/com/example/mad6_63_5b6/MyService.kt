package com.example.mad6_63_5b6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import kotlin.math.log


class MyService:Service(){
    lateinit var mediaPlayer: MediaPlayer
    val TAG="MyService"
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent,flages:Int,startId:Int):Int{
        if(!this::mediaPlayer.isInitialized)
            mediaPlayer=MediaPlayer.create(this,R.raw.song)
        if(intent!=null){
            val str1:String?=intent.getStringExtra("Service1")
            if(str1=="play"){
                if(!mediaPlayer.isPlaying)
                    mediaPlayer.start()
                else
                    mediaPlayer.pause()
                Log.i(TAG,"onStartCommand")
            }
        }
        else
        {
            mediaPlayer.start()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }

}