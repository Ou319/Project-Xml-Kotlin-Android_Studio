package com.example.ex13

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val displaychecked : Button by lazy{findViewById(R.id.btndisplayChecked)}
    val reverse : Button by lazy{findViewById(R.id.btnReverse)}
    val html : CheckBox by lazy{findViewById(R.id.IdHtml)}
    val css : CheckBox by lazy{findViewById(R.id.IdCss)}
    val python : CheckBox by lazy{findViewById(R.id.Idpy)}
    val ruby : CheckBox by lazy{findViewById(R.id.IdRuby)}
    val kt : CheckBox by lazy{findViewById(R.id.IdKt)}
    val dart : CheckBox by lazy{findViewById(R.id.IdDart)}

    val selections by lazy { listOf(html,css,python,ruby,kt,dart) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        reverse.setOnClickListener {
            for (selection in selections){
                selection.isChecked = !selection.isChecked
            }
        }

        displaychecked.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Selected Languages")
            val checked = selections.filter { it.isChecked }
            val icon = if (checked.isNotEmpty()) R.drawable.thumbs_up else R.drawable.thumbs_down
            alert.setIcon(icon)
            alert.setMessage(checked.joinToString("\n") { it.text.toString()})
            alert.setPositiveButton("OK", null)
            alert.setCancelable(false)
            alert.show()
        }
    }
}