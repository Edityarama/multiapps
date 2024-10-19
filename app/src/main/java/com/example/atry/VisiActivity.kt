package com.example.atry

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VisiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visi) // Ganti dengan layout Anda

        // Menampilkan teks pada TextView
        val textView: TextView = findViewById(R.id.textViewVisi)
        textView.text = "Visi dan Misi SMK N 2 Yogyakarta\n\n" +
                "Visi:  Menghasilkan Tamatan Yang Unggul, Berwawasan Lingkungan, Berkarakter, dan Berdaya Saing Global. Misi.\n\n" +
                "Misi:\n" +
                "1. Mengembangkan kurikulum pembelajaran berbasis Teaching Factory (TEFA).\n" +
                "2. Mengembangkan budaya literasi numerik, digital, finansial, sains, dan bahasa.\n" +
                "3. Mengembangkan kompetensi peserta didik sesuai dengan bakat dan minat."

        // Set onClickListener untuk tombol kembali
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)
        buttonGoBack.setOnClickListener {
            finish() // Kembali ke aktivitas sebelumnya
        }
    }
}
