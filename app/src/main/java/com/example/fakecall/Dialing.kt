package com.example.fakecall

import android.os.Bundle
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class Dialing : AppCompatActivity() {
    lateinit var myChrono: Chronometer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialing)

        myChrono = findViewById(R.id.chronometer2) as Chronometer
        myChrono.start()
    }

    fun quitCallEvent(view: View) {

        finish()
        System.exit(1)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}