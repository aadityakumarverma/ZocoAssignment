package com.example.zocnutassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zocnutassignment1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAlreadyRegistered.setOnClickListener {
            /*val intent= Intent(this@SignUpActivity,LoginActivity::class.java)
            startActivity(intent)*/
            finish()
        }
        binding.btnSignUp.setOnClickListener {
            val intent= Intent(this@SignUpActivity,HomeActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}