package com.example.atry

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Corrected layout resource ID

        // Reference the ImageView based on its ID and set onClickListener
        val buttonGoToNext: ImageView = findViewById(R.id.buttonGoToNext)

        // Set click listener for the ImageView
        buttonGoToNext.setOnClickListener {
            // Navigate to the CalculatorActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Referensi ImageView untuk Scan QR
        val buttonGoToNext2: ImageView = findViewById(R.id.buttonGoToNext2)

        // Set click listener untuk tombol Scan QR
        buttonGoToNext2.setOnClickListener {
            // Navigasi ke QRActivity
            val intent = Intent(this, QRActivity::class.java)
            startActivity(intent)
        }

        // Referensi ImageView untuk Visi Misi
        val buttonGoToNext3: ImageView = findViewById(R.id.buttonGoToNext3)

        // Set click listener untuk tombol Visi Misi
        buttonGoToNext3.setOnClickListener {
            // Navigasi ke VisiActivity
            val intent = Intent(this, VisiActivity::class.java)
            startActivity(intent)
        }

        val buttonGoToMap: ImageView = findViewById(R.id.buttonGoToNext4) // Tambahkan ID ini di layout
        buttonGoToMap.setOnClickListener {
            val intent = Intent(this, PetaActivity::class.java)
            startActivity(intent)
        }


    }
}
