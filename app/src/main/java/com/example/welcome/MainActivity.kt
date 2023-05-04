package com.example.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welcome.R.id.re1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnNext = findViewById<Button>(R.id.)
        btnNext.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

}