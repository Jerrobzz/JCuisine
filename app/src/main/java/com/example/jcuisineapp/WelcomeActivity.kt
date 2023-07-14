package com.example.jcuisineapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    lateinit var btnreg:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        btnreg = findViewById(R.id.btnregister)

        btnreg.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}