package com.example.ex02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex02.twoactivities.A01

class MainActivity : AppCompatActivity() {

    val n1 : EditText by lazy { findViewById(R.id.n1) }
    val n2 :EditText by lazy { findViewById(R.id.n2) }
    val pluse : RadioButton by lazy { findViewById(R.id.rdPlus) }
    val moins :RadioButton by lazy { findViewById(R.id.rdMinus) }
    val fois :RadioButton by lazy { findViewById(R.id.rdTimes) }
    private val btncalc: Button by lazy { findViewById(R.id.btnCalc) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btncalc.setOnClickListener {
            val num1=  n1.text.toString().toDouble()
            val num2=  n2.text.toString().toDouble()
            var dsplayResult =
                if (pluse.isChecked)
                    ( num1 + num2).toString()
                else if(moins.isChecked)
                    ( num1 - num2).toString()
                else if(fois.isChecked)
                    ( num1 * num2).toString()
                else
                    "No operation selected"

            val intent = Intent(this, A01::class.java)

            intent.putExtra("message",dsplayResult)
            startActivity(intent)

        }
    }
}