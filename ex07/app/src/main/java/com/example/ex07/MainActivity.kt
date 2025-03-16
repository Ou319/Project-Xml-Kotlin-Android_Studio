package com.example.ex07

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val red : Button by lazy { findViewById(R.id.btnred) }
    val blue : Button by lazy { findViewById(R.id.btnblue) }
    val yellow : Button by lazy { findViewById(R.id.btnyellow) }
    val view : View by lazy { findViewById(R.id.coloredView) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun ManageOnclick(mybn:Button,color: Int){
            view.setBackgroundColor(color)

            red.isEnabled=true
            blue.isEnabled=true
            yellow.isEnabled=true

            mybn.isEnabled=false
        }

        red.setOnClickListener {
            ManageOnclick(red,Color.RED)
        }
        blue.setOnClickListener {
            ManageOnclick(blue,Color.BLUE)
        }
        yellow.setOnClickListener {
            ManageOnclick(yellow,Color.YELLOW)
        }
    }
}