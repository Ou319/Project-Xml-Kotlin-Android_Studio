package com.example.ex20

import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val picker:NumberPicker by lazy { findViewById(R.id.nbrPicker) }
    val text:TextView by lazy { findViewById(R.id.textView) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        picker.minValue=0
        picker.maxValue=9
        // number picker
        picker.setOnValueChangedListener{picker,i,value->
            text.text=value.toString()
        }

        // date picker

    }
}