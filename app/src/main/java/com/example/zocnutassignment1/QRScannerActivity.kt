package com.example.zocnutassignment1


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zocnutassignment1.databinding.ActivityQrscannerBinding


class QRScannerActivity : AppCompatActivity() {
    lateinit var binding: ActivityQrscannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrscannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }

        binding.btnScanThisQR.setOnClickListener {
            val intent = Intent(this@QRScannerActivity, CardViewerActivity::class.java)
            startActivity(intent)
        }

    }


}