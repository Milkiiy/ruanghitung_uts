package com.example.uts

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text

class Register_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        val registerBtn: MaterialButton = findViewById(R.id.btn_register)
        val backBtn: MaterialButton = findViewById(R.id.back_login)
        val username: TextView = findViewById(R.id.username)
        val password: TextView = findViewById(R.id.password)
        val email: TextView = findViewById(R.id.email)
        val birth: TextView = findViewById(R.id.birth)

        registerBtn.setOnClickListener{

            if (username.text.toString().isEmpty() || password.text.toString().isEmpty() || email.text.toString().isEmpty() || birth.text.toString().isEmpty()){
                Toast.makeText(this, "Gagal registrasi. Harap isi semua kolom.",Toast.LENGTH_SHORT).show()
            } else {
                val message : String? = "Apakah Anda Yakin?"
                val judul : String? = "Registrasi Form"
                showCustomDialogBox(message,judul)
            }
        }

        backBtn.setOnClickListener{
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }

    }

    private fun showCustomDialogBox(message: String?,judul: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_dialog_logout)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tv_message)
        val btnYes : Button = dialog.findViewById(R.id.btn_yes)
        val btnNo : Button = dialog.findViewById(R.id.btn_no)
        val tvJudul : TextView = dialog.findViewById(R.id.tv_judul)

        tvMessage.text = message
        tvJudul.text = judul

        btnYes.setOnClickListener{
            Toast.makeText(this,"Registrasi Berhasil",Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }
}