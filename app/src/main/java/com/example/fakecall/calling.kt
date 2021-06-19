package com.example.fakecall

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class calling : AppCompatActivity() {
    lateinit var callername: TextView
    lateinit var player: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling)

        callername = findViewById(R.id.textView4)
        var intent = intent
        var name = intent.getStringExtra("name")
        Toast.makeText(this, "name = " + name, Toast.LENGTH_SHORT).show()
        callername.text = name

        //backgroundMusic
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.setLooping(true)
        if (player.isPlaying) {
        } else {
            player.start()
        }

    }

    fun acceptCallEvent(view: View?) {
        val acceptCall = Intent(this, Dialing::class.java)
        startActivity(acceptCall)
        player.stop()
        finish()
    }

    fun denyCall(view: View?) {
        player.stop()
        finishAffinity()
    }

    override fun onStop() {
        super.onStop()

        player.stop()
    }
}