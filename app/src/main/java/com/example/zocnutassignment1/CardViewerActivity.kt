package com.example.zocnutassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zocnutassignment1.databinding.ActivityCardViewerBinding

class CardViewerActivity : AppCompatActivity() {
    lateinit var binding: ActivityCardViewerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCardViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
    }
}