package com.example.ex04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val n : EditText by lazy { findViewById(R.id.n) }
    val partier : Button by lazy { findViewById(R.id.btnPartier) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        partier.setOnClickListener {


            try{
                val alert = AlertDialog.Builder(this)

                val result = if ((n.text.toString().toDouble() % 2) == 0.0) "pair" else "impair"

                alert.setTitle("Greetings")
                alert.setMessage("${n.text.toString()} est $result")
                alert.setIcon(android.R.drawable.ic_dialog_info)

                alert.show()
            }catch (e:Exception){

            }
        }
    }
}