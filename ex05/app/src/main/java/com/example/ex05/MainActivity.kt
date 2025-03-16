package com.example.ex05

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private val number :EditText by lazy {findViewById(R.id.n)}
    val displayResult : TextView by lazy { findViewById(R.id.result) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                displayResult.text = if(number.text.toString().toDouble()%2 == 0.0) "${number.text} est pair" else "${number.text} est impair"
                displayResult.setTextColor(Color.parseColor("#8BC34A"));
            }

        })

    }
}

