package com.example.ex11

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val previmg :ImageButton by lazy{findViewById(R.id.btnprev)}
    val nextimg :ImageButton by lazy{findViewById(R.id.btnnext)}
    val image :ImageView by lazy{findViewById(R.id.changeableImage)}
    val imagetitle :TextView by lazy{findViewById(R.id.imageName)}

    val data = listOf(
        Pair("Cactus", R.drawable.cactus),
        Pair("Alps", R.drawable.alps),
        Pair("Grass", R.drawable.grass),
        Pair("Hazelnut", R.drawable.hazelnut),
        Pair("Hops", R.drawable.hops),
        Pair("Iceberg", R.drawable.iceberg),
        Pair("Palm", R.drawable.palm),
        Pair("Nut", R.drawable.nut),
        Pair("Seawave", R.drawable.seawaves),
        Pair("Tomato", R.drawable.tomato),
        Pair("Tree", R.drawable.tree),
        Pair("Wheat", R.drawable.wheat)
    )

    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        nextimg.setOnClickListener{
            if (currentIndex < data.size - 1) {
                currentIndex++
                imagetitle.text = data[currentIndex].first
                image.setImageResource(data[currentIndex].second)
            }
        }

        previmg.setOnClickListener{
            if (currentIndex > 0) {
                currentIndex--
                imagetitle.text = data[currentIndex].first
                image.setImageResource(data[currentIndex].second)
            }
        }
    }
}