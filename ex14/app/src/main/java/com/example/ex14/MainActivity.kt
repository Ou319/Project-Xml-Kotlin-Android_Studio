package com.example.ex14

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var toggleButton: ToggleButton
    private lateinit var secondSpinner: Spinner
    private lateinit var permanentTextView: TextView
    private lateinit var marriedCheckBox: CheckBox
    private lateinit var vacataireTextView: TextView
    private lateinit var hoursTextView: TextView
    private lateinit var textEnfant: TextView
    private lateinit var hoursEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        setupSpinners()
        setupListeners()
    }

    private fun initViews() {
        toggleButton = findViewById(R.id.usrType)
        secondSpinner = findViewById(R.id.nbrenfant)
        permanentTextView = findViewById(R.id.Permanant)
        marriedCheckBox = findViewById(R.id.ismariee)
        vacataireTextView = findViewById(R.id.Vacataire)
        hoursTextView = findViewById(R.id.nbh)
        hoursEditText = findViewById(R.id.nbheures)
        resultTextView = findViewById(R.id.DisplaySalary)
        calculateButton = findViewById(R.id.calculer)
        textEnfant = findViewById(R.id.textView3)

        secondSpinner.isEnabled = false
        textEnfant.isEnabled = false
    }

    private fun setupSpinners() {
        val childrenAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            (0..5).map { it.toString() }.toTypedArray())
        childrenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        secondSpinner.adapter = childrenAdapter
    }

    private fun setupListeners() {
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            updateUIBasedOnEmploymentType(!isChecked)
        }
        updateUIBasedOnEmploymentType(!toggleButton.isChecked)

        calculateButton.setOnClickListener { calculateSalary() }

        marriedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            secondSpinner.isEnabled = isChecked
            textEnfant.isEnabled = isChecked
        }
    }

    private fun updateUIBasedOnEmploymentType(isPermanent: Boolean) {
        permanentTextView.isEnabled = isPermanent
        marriedCheckBox.isEnabled = isPermanent
        secondSpinner.isEnabled = isPermanent && marriedCheckBox.isChecked
        textEnfant.isEnabled = isPermanent && marriedCheckBox.isChecked

        val isVacataire = !isPermanent
        vacataireTextView.isEnabled = isVacataire
        hoursTextView.isEnabled = isVacataire
        hoursEditText.isEnabled = isVacataire
    }

    private fun calculateSalary() {
        val isPermanent = !toggleButton.isChecked
        if (isPermanent) {
            var result = 10000.0
            val isMarried = marriedCheckBox.isChecked
            val childrenCount = if (isMarried) secondSpinner.selectedItem.toString().toInt() else 0
            result += if (isMarried) childrenCount * 200.0 else 0.0
            resultTextView.text = result.toString()
        } else {
            try {
                val hours = hoursEditText.text.toString().toDouble()
                resultTextView.text = (hours * 250.0).toString()
            } catch (e: Exception) {
                resultTextView.text = getString(R.string.problem)
            }
        }
    }
}