package com.example.ex09

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val n : EditText by lazy { findViewById(R.id.number) }
    val numimage : ImageView by lazy { findViewById(R.id.shownImage) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        n.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                when(s.toString()){
                    "0" -> numimage.setImageResource(R.drawable.zero)
                    "1" -> numimage.setImageResource(R.drawable.one)
                    "2" -> numimage.setImageResource(R.drawable.two)
                    "3" -> numimage.setImageResource(R.drawable.three)
                    "4" -> numimage.setImageResource(R.drawable.four)
                    "5" -> numimage.setImageResource(R.drawable.five)
                    "6" -> numimage.setImageResource(R.drawable.six)
                    "7" -> numimage.setImageResource(R.drawable.seven)
                    "8" -> numimage.setImageResource(R.drawable.eight)
                    "9" -> numimage.setImageResource(R.drawable.nine)
                    else->{
                        numimage.setImageResource(R.drawable.error)
                    }
                }
            }

        })
    }
}