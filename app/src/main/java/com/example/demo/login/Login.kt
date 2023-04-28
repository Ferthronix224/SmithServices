package com.example.demo.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.demo.MainActivity
import com.example.demo.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button = findViewById<Button>(R.id.btnLogin)
        val mensaje = findViewById<TextView>(R.id.mensaje)
        val txtUser = findViewById<EditText>(R.id.txtUser)
        val txtPass = findViewById<EditText>(R.id.txtPass)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val user = txtUser.text.trim().toString()
            val pass = txtPass.text.trim().toString()
            if (user.equals("isra") && pass.equals("1234")) {
                startActivity(intent)
                finish()
            } else if (user.equals("fer") && pass.equals("1234")) {
                startActivity(intent)
                finish()
            } else if (user.equals("benito") && pass.equals("1234")) {
                startActivity(intent)
                finish()
            } else {
                txtUser.text.clear()
                txtPass.text.clear()
                mensaje.text = "Credenciales Incorrectas"
            }
        }
    }
}