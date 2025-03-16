package com.example.ex16

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val spinnerofThemes: Spinner by lazy { findViewById(R.id.spinnerTheme) }
        val changeable: TextView by lazy { findViewById(R.id.changeableText) }

        val listofThemes = listOf("Regular", "Bold", "Italic")

        val fillspinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, listofThemes)
        fillspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerofThemes.adapter = fillspinner

        spinnerofThemes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when{
                    listofThemes[position] == "Regular" -> changeable.setTypeface(Typeface.DEFAULT)
                    listofThemes[position] == "Bold" -> changeable.setTypeface(Typeface.DEFAULT_BOLD)
                    listofThemes[position] == "Italic" -> changeable.setTypeface(Typeface.DEFAULT, Typeface.ITALIC)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}