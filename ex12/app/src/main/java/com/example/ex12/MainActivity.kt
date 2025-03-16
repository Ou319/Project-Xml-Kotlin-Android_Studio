package com.example.ex12

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val s1 : ImageButton by lazy{findViewById(R.id.star1)}
    val s2 : ImageButton by lazy{findViewById(R.id.star2)}
    val s3 : ImageButton by lazy{findViewById(R.id.star3)}
    val s4 : ImageButton by lazy{findViewById(R.id.star4)}
    val s5 : ImageButton by lazy{findViewById(R.id.star5)}
    val resetbtn : Button by lazy{findViewById(R.id.btnreset)}

    val stars by lazy { listOf( s1, s2, s3, s4, s5) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        for (star in stars) {
            star.setOnClickListener {
                val clickedIndex = stars.indexOf(star)
                for (i in stars.indices) {
                    if (i <= clickedIndex) {
                        stars[i].setImageResource(R.drawable.filledstar)
                    } else {
                        stars[i].setImageResource(R.drawable.star)
                    }
                }
            }
        }

        resetbtn.setOnClickListener {
            for (star in stars) {
                star.setImageResource(R.drawable.star)
            }
        }
    }
}