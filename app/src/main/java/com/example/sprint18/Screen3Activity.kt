package com.example.sprint18

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
private const val interval = 2000L

class Screen3Activity : AppCompatActivity(R.layout.activity_screen3) {
    private val handler = Handler(Looper.getMainLooper())
    val callBackPressedScreen3ButtonBack = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
          Toast.makeText(this@Screen3Activity, getString(R.string.toast_screen3_message), Toast.LENGTH_LONG).show()
        }

    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d("NAVEXAMPLE", "Screen3 -> onNewIntent")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("NAVEXAMPLE", "Screen3 -> onCreate")

        findViewById<TextView>(R.id.screen3Title).text = "Screen 3 [$this]"

        findViewById<Button>(R.id.screen3ButtonToScreen1).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'To screen 1'")
            openScreen1()
        }

        findViewById<Button>(R.id.screen3ButtonBack).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back'")
            backToPreviousScreen()
        }

        findViewById<Button>(R.id.screen3ButtonToScreen3).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'To screen 3'")
            openScreen3()
        }

        findViewById<Button>(R.id.screen3ButtonToScreen1WithClear).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back to Screen 1'")
            backToScreen1()
        }
    }

    fun backToScreen1(){
        val intent = Intent(this, Screen1Activity::class.java)

        this.startActivity(intent)
    }


    private fun openScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)

        this.startActivity(intent)
    }

    private fun backToPreviousScreen() {
        onBackPressedDispatcher.addCallback(callBackPressedScreen3ButtonBack)
        this.onBackPressedDispatcher.onBackPressed()
        callBackIsEnabledInstaller()

    }

    private fun openScreen3() {
        val intent = Intent(this, Screen3Activity::class.java)

        this.startActivity(intent)
    }
    private fun callBackIsEnabledInstaller(){
        callBackPressedScreen3ButtonBack.isEnabled = false
        handler.postDelayed({callBackPressedScreen3ButtonBack.isEnabled=true}, interval)
    }
}