package com.example.randomgenerator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var findColor = findViewById<Button>(R.id.find_beer)
        findColor.setOnClickListener{
            var beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem
            val brands = findViewById<TextView>(R.id.brands)

            val beerList = getBeers(color.toString())
            val beers = beerList.reduce{str, item -> str + '\n' + item}
            brands.text = beers
        }
    }

        fun getBeers(color: String): List<String> {
            return when (color) {
                "Black" -> listOf("Coca cola", "Pepsi", "Kvas")
                "Green" -> listOf("7Up", "Sprite", "GreenTea", "LaimonFresh")
                "Red" -> listOf("Mors", "LaimonFresh")
                else -> listOf("MaxTea", "Fanta")
            }
        }
}