package com.guanacobusiness

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guanacobusiness.dto.Login.RetrofitInstanceLogin
import com.guanacobusiness.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            if (RetrofitInstanceLogin.getUser() == "") {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            setContentView(R.layout.activity_main)
        }
    }
