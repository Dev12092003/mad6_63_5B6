package com.example.mad6_63_5b6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var togglePlayButton=true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playbtn=findViewById<FloatingActionButton>(R.id.play)
        val stopbtn=findViewById<FloatingActionButton>(R.id.stop)

        playbtn.setOnClickListener{
            Intent(applicationContext,MyService::class.java).
            putExtra("Service1","play").apply{
                startService(this)
            }
            if(togglePlayButton){
                togglePlayButton=false
                playbtn.setImageResource(R.drawable.run)
            }
            else{
                togglePlayButton=true
                playbtn.setImageResource(R.drawable.baseline_stop_24)
            }
        }
        stopbtn.setOnClickListener{
            Intent(applicationContext,MyService::class.java).apply {
                stopService(this)
                if(!togglePlayButton){
                    togglePlayButton=true
                    playbtn.setImageResource(R.drawable.baseline_stop_24)
                }
            }
        }
    }
}