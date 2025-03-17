package com.example.ex21

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val input1: EditText by lazy { findViewById(R.id.input1) }
    val input2: EditText by lazy { findViewById(R.id.input2) }
    val mybtn: Button by lazy { findViewById(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun showDialog(targetInput: EditText) {
            val dialogView = layoutInflater.inflate(R.layout.firstpoint, null)

            val myAlert = AlertDialog.Builder(this@MainActivity)
                .setView(dialogView)
                .setCancelable(true)
                .create()

            myAlert.show()

            val First_input1: EditText = dialogView.findViewById(R.id.input3)
            val First_input2: EditText = dialogView.findViewById(R.id.input4)
            val First_button: Button = dialogView.findViewById(R.id.button2)

            First_button.setOnClickListener {
                val value_First_input1 = First_input1.text.toString()
                val value_First_input2 = First_input2.text.toString()

                targetInput.setText("($value_First_input1 - $value_First_input2)")
                myAlert.dismiss()
            }
        }

        input1.setOnClickListener { showDialog(input1) }
        input2.setOnClickListener { showDialog(input2) }

        mybtn.setOnClickListener {
            val regex = """\((\d+)\s*-\s*(\d+)\)""".toRegex()

            val match1 = regex.find(input1.text.toString())
            val match2 = regex.find(input2.text.toString())

            if (match1 != null && match2 != null) {
                val value1 = match1.groupValues[1].toInt() + match1.groupValues[2].toInt()
                val value2 = match2.groupValues[1].toInt() + match2.groupValues[2].toInt()

                val result = (value1 + value2) * 2


                Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "enterthe value", Toast.LENGTH_LONG).show()
            }
        }
    }
}
