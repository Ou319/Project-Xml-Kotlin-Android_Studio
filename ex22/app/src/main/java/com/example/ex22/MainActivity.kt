package com.example.ex22

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    val btnOk:Button by lazy { findViewById(R.id.btn1) }
    val text1:TextView by lazy { findViewById(R.id.text1) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnOk.setOnClickListener(){
            val inputdialog=inputDialogue(this@MainActivity)

            // set text 1 = value of the input in alert


            inputdialog.ValueInput(text1)


            inputdialog.setInput(text1.text.toString())
            // show the dialoge
            inputdialog.show()




        }
        Snackbar.make(btnOk,"${text1.text}",Snackbar.LENGTH_SHORT).show()
    }
}