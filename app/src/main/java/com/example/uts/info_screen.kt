package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class info_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_screen)
        val homeBtn: MaterialButton = findViewById(R.id.btn_home)

        homeBtn.setOnClickListener{
            val Intent = Intent(this,Home_Screen::class.java)
            startActivity(Intent)
        }
    }
}