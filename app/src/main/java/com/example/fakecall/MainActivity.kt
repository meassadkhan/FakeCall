package com.example.fakecall

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var player: MediaPlayer
    lateinit var rGroup: RadioGroup
    var afterTime: Int = 0
    lateinit var waitingTime: String
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var write_Name = findViewById<EditText>(R.id.textView2)

        name = write_Name.text.toString()

        rGroup = findViewById(R.id.rBtnGroup)
        rGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rBtnNow) {
                afterTime = 0
            } else if (checkedId == R.id.rBtnOne) {
                afterTime = 15000
                waitingTime = "Wait 15 Second"
            } else if (checkedId == R.id.rBtnFive) {
                afterTime = 60000
                waitingTime = "Wait 1 minute"
            } else if (checkedId == R.id.rBtnThirty) {
                afterTime = 1800000
                waitingTime = "Wait 30 minutes"
            } else if (checkedId == R.id.rBtnHour) {
                afterTime = 3600000
                waitingTime = "Wait 1 hour"
            }
        })
    }

    fun callBtnEvent(view: View) {

        val callEvent = Intent(this, calling::class.java)
        callEvent.putExtra("name", name)
        startActivity(callEvent)

    }
}