package com.example.coleccionconsolas

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }else{
            startActivity(Intent(this, SplashAntiguoActivity::class.java))
            finish()
        }

    }
}