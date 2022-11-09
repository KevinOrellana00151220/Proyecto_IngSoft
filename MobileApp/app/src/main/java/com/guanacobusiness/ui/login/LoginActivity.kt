package com.guanacobusiness.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.guanacobusiness.MainActivity
import com.guanacobusiness.databinding.FragmentAddJobOfferBinding
import com.guanacobusiness.databinding.FragmentLoginBinding
import com.guanacobusiness.dto.Login.LoginRequest
import com.guanacobusiness.dto.Login.LoginService
import com.guanacobusiness.dto.Login.RetrofitInstanceLogin
import com.guanacobusiness.ui.register.RegisterActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var binding2: FragmentAddJobOfferBinding


    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding2 = FragmentAddJobOfferBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener(this)
        binding.signUp.setOnClickListener(this)
    }
    //Function to login when click on login button
    private fun logging() {
        val email = binding.usernameInput.text.toString()
        val password = binding.passwordInput.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitInstanceLogin.retrofit.create(LoginService::class.java).login(
                LoginRequest(email, password)
            )
            val response = call.body()
            runOnUiThread {

                //For testing purposes
                if (call.isSuccessful) {
                    RetrofitInstanceLogin.setUser("$email")
                    startMainActivity()

                } else {
                    binding.textToken.text = "Email o contraseña incorrectos"
                }
            }
        }
    }


    private fun showError() {
        //show error
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.loginButton -> {
                logging()
            }
            binding.signUp -> {
                goToRegisterFragment()
            }
            else -> {
                showError()
            }
        }
    }

    private fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRegisterFragment(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }


}