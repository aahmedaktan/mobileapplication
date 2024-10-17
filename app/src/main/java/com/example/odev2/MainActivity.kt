package com.example.odev2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.imageView4)

        val textView2 = findViewById<TextView>(R.id.textView2)
        val anaYemeklerGroup = findViewById<RadioGroup>(R.id.anaYemeklerGroup)

        val textView3 = findViewById<TextView>(R.id.textView3)
        val MercimekCorbasi = findViewById<CheckBox>(R.id.checkBox)
        val Salata = findViewById<CheckBox>(R.id.checkBox2)
        val Kizartma = findViewById<CheckBox>(R.id.checkBox3)

        val textView4 = findViewById<TextView>(R.id.textView4)
        val iceceklerGroup = findViewById<RadioGroup>(R.id.iceceklerGroup)

        val siparisButton = findViewById<Button>(R.id.siparis)

        siparisButton.setOnClickListener {
            val selectedAnaYemekId = anaYemeklerGroup.checkedRadioButtonId
            val selectedIcecekId = iceceklerGroup.checkedRadioButtonId

            val anaYemek = when (selectedAnaYemekId) {
                R.id.radioButton -> "Kavurma"
                R.id.radioButton2 -> "Tavuk Sote"
                R.id.radioButton3 -> "Kuru Fasulye"
                else -> ""
            }

            val ekstralar = mutableListOf<String>()
            if (MercimekCorbasi.isChecked) {
                ekstralar.add("Mercimek Çorbası")
            }
            if (Salata.isChecked) {
                ekstralar.add("Salata")
            }
            if (Kizartma.isChecked) {
                ekstralar.add("Kızartma")
            }

            val ekstralarString = ekstralar.joinToString(", ")

            val icecek = when (selectedIcecekId) {
                R.id.radioButton4 -> "Ayran"
                R.id.radioButton5 -> "Şalgam"
                R.id.radioButton6 -> "Soda"
                else -> ""
            }

            // Sipariş bilgilerini burada işleyin
            Toast.makeText(this, "Seçtiğiniz ürünler kaydedildi: $anaYemek, Ekstralar: $ekstralarString, İçecek: $icecek", Toast.LENGTH_LONG).show()
        }
    }
}
