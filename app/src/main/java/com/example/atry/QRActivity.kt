package com.example.atry

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class QRActivity : AppCompatActivity() {

    private lateinit var barcodeView: DecoratedBarcodeView
    private lateinit var resultTextView: TextView
    private var isScanning = false // Track scanning status
    private var lastScannedText: String? = null // Store last scanned text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr) // Replace with your layout

        // Initialize TextView
        resultTextView = findViewById(R.id.textViewResult)

        // Request camera permission if not granted
        if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 101)
        } else {
            initializeBarcodeView()
        }
    }

    private fun initializeBarcodeView() {
        // Initialize barcode view
        barcodeView = findViewById(R.id.barcode_scanner)
        barcodeView.decodeContinuous(callback)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initializeBarcodeView()
        } else {
            Log.d("QRActivity", "Camera permission denied")
        }
    }

    // Callback for scan results
    private val callback = BarcodeCallback { result: BarcodeResult ->
        val scannedText = result.text
        if (isScanning || scannedText == lastScannedText) return@BarcodeCallback // Ignore duplicate scans

        isScanning = true
        lastScannedText = scannedText
        Log.d("QRActivity", "Scanned text: $scannedText")

        // Display the scanned result immediately
        resultTextView.text = scannedText

        // Open browser if scanned result is a URL
        if (scannedText.startsWith("http://") || scannedText.startsWith("https://")) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(scannedText))
            startActivity(browserIntent)
        } else {
            Log.d("QRActivity", "Not a valid URL")
        }

        // Use a handler to introduce a short delay before allowing another scan
        Handler().postDelayed({
            isScanning = false
            lastScannedText = null // Reset last scanned text
        }, 1000) // 1 second delay to allow quick scans
    }

    override fun onResume() {
        super.onResume()
        barcodeView.resume()
    }

    override fun onPause() {
        super.onPause()
        barcodeView.pause()
    }
}
