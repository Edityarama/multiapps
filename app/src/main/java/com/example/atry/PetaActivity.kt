package com.example.atry

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PetaActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peta)

        // Inisialisasi WebView
        webView = findViewById(R.id.webViewMap)
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)

        // Mengatur pengaturan WebView
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // Muat peta statis dari URL
        val latitude = -7.250445 // Ganti dengan latitude yang diinginkan
        val longitude = 112.768845 // Ganti dengan longitude yang diinginkan
        val url = "https://www.openstreetmap.org/#map=15/$latitude/$longitude"
        webView.loadUrl(url)

        // Set onClickListener untuk tombol kembali
        buttonGoBack.setOnClickListener {
            finish() // Kembali ke aktivitas sebelumnya
        }
    }
}
