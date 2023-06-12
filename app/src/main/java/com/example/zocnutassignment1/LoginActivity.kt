package com.example.zocnutassignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.text.InputFilter
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.zocnutassignment1.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var flagGo=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnGoogleLogIn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.g_google_icon, 0,0,  0)

        val maxUserNameLength =40
        binding.etEmailId.filters= arrayOf<InputFilter>(InputFilter.LengthFilter(maxUserNameLength))

        val maxPasswordLength =30
        binding.etPassword.filters= arrayOf<InputFilter>(InputFilter.LengthFilter(maxPasswordLength))




        binding.etEmailId.doOnTextChanged { text, start, before, count ->
            funValidateEmail()
        }
        binding.etPassword.doOnTextChanged { text, start, before, count ->
            funValidatePassword()
        }

        binding.btnLogIn.setOnClickListener{
            funValidateLogin()

        }
        binding.flGoogleLogIn.setOnClickListener {
            val intent= Intent(this@LoginActivity,HomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnGoogleLogIn.setOnClickListener {
            val intent= Intent(this@LoginActivity,HomeActivity::class.java)
            startActivity(intent)
        }

        binding.tvNewUser.setOnClickListener {
            val intent= Intent(this@LoginActivity,SignUpActivity::class.java)
            startActivity(intent)
        }
    }



    private fun funValidateEmail() {



        if (binding.etEmailId.text.toString().isEmpty())
        {binding.etEmailId.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validateEmailId.isVisible=true
            binding.validateEmailId.text="*Please enter your email."

        }
        else if(binding.etEmailId.text.contains(" "))
        {
            binding.etEmailId.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validateEmailId.isVisible=true
            binding.validateEmailId.text="*Space is not Allowed."
        }
        else if (binding.etEmailId.text.toString().length<6)
        {binding.etEmailId.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validateEmailId.isVisible=true
            binding.validateEmailId.text="*Please enter at least 6 characters"
        }
        else if (!binding.etEmailId.text.toString().matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}".toRegex()))
        {binding.etEmailId.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validateEmailId.isVisible=true
            binding.validateEmailId.text="*Please enter valid email."
        }

        else
        {
            binding.etEmailId.setBackgroundResource(R.drawable.edit_text_background)
            binding.validateEmailId.isVisible=false
            flagGo++
        }
    }


    private fun funValidatePassword() {


        if (binding.etPassword.text.toString().isEmpty())
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Please enter your password."

        }
        else if(binding.etPassword.text.contains(" "))
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Space is not allowed."
        }
        else if (binding.etPassword.text.toString().length<6)
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Please enter at least 6 characters."
        }
        else if (!binding.etPassword.text.toString().contains("[a-z]".toRegex()))
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Insert at least one small letter."
        }
        else if (!binding.etPassword.text.toString().contains("[A-Z]".toRegex()))
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Insert at least one capital letter."
        }
        else if (!binding.etPassword.text.toString().contains("[0-9]".toRegex()))
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Insert at least one digit."
        }

        else if (!binding.etPassword.text.toString().contains("[\\!@#$%^&*()_+/|\\-?>.<,:;'\"]".toRegex()))
        {binding.etPassword.setBackgroundResource(R.drawable.edit_text_red_background)
            binding.validatePassword.isVisible=true
            binding.validatePassword.text="*Insert at least one special character."
        }

        else
        {
            binding.etPassword.setBackgroundResource(R.drawable.edit_text_background)
            binding.validatePassword.isVisible=false
            flagGo++
        }
    }

  
    

    private fun funValidateLogin() {

        flagGo=0
        funValidateEmail()
        funValidatePassword()
        if (flagGo == 2) {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            finish()
            startActivity(intent)

        }


    }



}