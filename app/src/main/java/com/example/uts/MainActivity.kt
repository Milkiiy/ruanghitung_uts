package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username: TextView = findViewById(R.id.username)
        val password: TextView = findViewById(R.id.password)
        val loginBtn: MaterialButton = findViewById(R.id.btn_login)
        val registerBtn: MaterialButton = findViewById(R.id.btn_register)

        loginBtn.setOnClickListener {
            if (username.text.toString() == "admin" && password.text.toString() == "admin") {
                Toast.makeText(this@MainActivity, "Login Success", Toast.LENGTH_SHORT).show()
                val Intent = Intent(this,info_screen::class.java)
                startActivity(Intent)
            } else {
                Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        registerBtn.setOnClickListener{
            val Intent = Intent(this,Register_Screen::class.java)
            startActivity(Intent)
        }
    }
}