package com.example.ex06

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val red:Button by lazy { findViewById(R.id.btnred) }
    val blue:Button by lazy { findViewById(R.id.btnblue) }
    val yellow:Button by lazy { findViewById(R.id.btnyellow) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        red.setOnClickListener {
            window.decorView.setBackgroundColor(Color.RED)
        }
        blue.setOnClickListener {
            window.decorView.setBackgroundColor(Color.BLUE)
        }
        yellow.setOnClickListener {
            window.decorView.setBackgroundColor(Color.YELLOW)
        }
    }
}