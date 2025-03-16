package com.example.ex15

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val continentSpinner: Spinner = findViewById(R.id.continentSpinner)
        val countriesSpinner: Spinner = findViewById(R.id.countriesSpinner)
        val populationDispalay: TextView by lazy { findViewById(R.id.population) }

        val continents = listOf("Africa", "Oceania", "Asia", "Europe", "North America", "South America")

        val countries = listOf(
        Pair("Algeria", "Africa"),
        Pair("Nigeria", "Africa"),
        Pair("Ethiopia", "Africa"),
        Pair("Egypt", "Africa"),
        Pair("Australia", "Oceania"),
        Pair("Papua New Guinea", "Oceania"),
        Pair("New Zealand", "Oceania"),
        Pair("China", "Asia"),
        Pair("India", "Asia"),
        Pair("Indonesia", "Asia"),
        Pair("Russia", "Europe"),
        Pair("Germany", "Europe"),
        Pair("United Kingdom ", "Europe"),
        Pair("United States", "North America"),
        Pair("Canada", "North America"),
        Pair("Mexico", "North America"),
        Pair("Brazil", "South America"),
        Pair("Argentina", "South America"),
        Pair("Colombia", "South America"),
        )

        val population = listOf(
            Pair("Nigeria", "~223 000 000"),
            Pair("Ethiopia", "~126 000 000"),
            Pair("Egypt", "~112 000 000"),
            Pair("China", "~1 410 000 000"),
            Pair("India", "~1 400 000 000"),
            Pair("Indonesia", "~277 000 000"),
            Pair("Russia", "~146 000 000"),
            Pair("Germany", "~83 000 000"),
            Pair("United Kingdom ", "~67 000 000"),
            Pair("United States", "~332 000 000"),
            Pair("Canada", "~38 000 000"),
            Pair("Mexico", "~130 000 000"),
            Pair("Brazil", "~212 000 000"),
            Pair("Argentina", "~45 000 000"),
            Pair("Colombia", "~50 000 000"),
            Pair("Algeria", "~43 000 000"),
            Pair("Australia", "~25 000 000"),
            Pair("Papua New Guinea", "~8 000 000"),
            Pair("New Zealand", "~5 000 000"),
        )

        val continentsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, continents)
        continentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        continentSpinner.adapter = continentsAdapter


        continentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedContinent = continents[position]

                val countriesAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, countries.filter { it.second == selectedContinent }.map { it.first })
                countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                countriesSpinner.adapter = countriesAdapter

                countriesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val selectedCountry = countriesAdapter.getItem(position)
                        val selectedPopulation = population.find { it.first == selectedCountry }?.second ?: "Population not found"
                        populationDispalay.text = selectedPopulation
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }



        }

//        countriesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
////                val selectedCountry = countries[position].first
////                val selectedPopulation = population.find { it.first == selectedCountry }?.second ?: "Population not found"
////                populationDispalay.text = selectedPopulation
//                val selectedCountry = countries[position].first
//
//                val populationAdapter =  population.find { it.first == selectedCountry }?.second ?: "Population not found"
//                populationDispalay.text = populationAdapter
//
//            }

//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//
//        }


//        lateinit var countriesAdapter: ArrayAdapter<String>
//        for (selectedContinent in continents) {
//            if (selectedContinent == continentSpinner.selectedItem) {
//                countriesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries.filter { it.second == selectedContinent }.map { it.first })
//                countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            }
//            countriesSpinner.adapter = countriesAdapter
//
//        }


    }
}
