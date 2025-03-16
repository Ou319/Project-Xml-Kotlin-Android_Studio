package com.example.ex02.twoactivities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex02.R

class A01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val btnBack: Button by lazy { findViewById(R.id.btnback) }
//        val n1 : EditText by lazy { findViewById(R.id.n1) }
//        val n2 : EditText by lazy { findViewById(R.id.n2) }
//        val pluse : RadioButton by lazy { findViewById(R.id.rdPlus) }
//        val moins : RadioButton by lazy { findViewById(R.id.rdMinus) }
//        val fois : RadioButton by lazy { findViewById(R.id.rdTimes) }
        val dsplayResult : TextView by lazy { findViewById(R.id.displayresult) }


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a01)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack.setOnClickListener {
            finish()
        }
        dsplayResult.text = intent.getStringExtra("message").toString()
    }
}