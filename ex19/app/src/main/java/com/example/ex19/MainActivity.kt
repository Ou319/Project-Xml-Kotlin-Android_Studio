package com.example.ex19

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val text1:TextView by lazy { findViewById(R.id.textView2) }
    val btn:Button by lazy { findViewById(R.id.button) }
    var mybool=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn.setOnClickListener(){
            btn.setOnClickListener {
                if (mybool) {
                    text1.background = ContextCompat.getDrawable(this, R.drawable.custome_shapes_2)
                } else {
                    text1.background = ContextCompat.getDrawable(this, R.drawable.custome_shapes_1)
                }
                mybool = !mybool
            }

        }
    }
}