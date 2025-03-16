package com.example.ex10

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

    val number: EditText by lazy {findViewById(R.id.imagenum)}
    val img1: ImageView by lazy {findViewById(R.id.imagen1)}
    val img2: ImageView by lazy {findViewById(R.id.imagen2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        number.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()


                if (text.length == 1 ) {
                    val digit = text[0]
                    img1.setImageResource(getDrawableForDigit('0'))
                    img2.setImageResource(getDrawableForDigit(digit))
                } else if (text.length == 2) {
                    val digit1 = text[0]
                    val digit2 = text[1]
                    img1.setImageResource(getDrawableForDigit(digit1))
                    img2.setImageResource(getDrawableForDigit(digit2))
                }
                else{
                    img1.setImageResource(getDrawableForDigit('0'))
                    img2.setImageResource(getDrawableForDigit('0'))
                }
            }

            private fun getDrawableForDigit(digit: Char): Int {
                return when (digit) {
                    '0' -> R.drawable.zero
                    '1' -> R.drawable.one
                    '2' -> R.drawable.two
                    '3' -> R.drawable.three
                    '4' -> R.drawable.four
                    '5' -> R.drawable.five
                    '6' -> R.drawable.six
                    '7' -> R.drawable.seven
                    '8' -> R.drawable.eight
                    '9' -> R.drawable.nine
                    else -> R.drawable.zero
                }
            }

        })
    }
}