package com.example.zocnutassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zocnutassignment1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivQRScanner.setOnClickListener {
            val intent= Intent(this@HomeActivity,QRScannerActivity::class.java)
            startActivity(intent)
        }
        binding.ivContactList.setOnClickListener {
            val intent= Intent(this@HomeActivity,AllContactsActivity::class.java)
            startActivity(intent)
        }

    }
}