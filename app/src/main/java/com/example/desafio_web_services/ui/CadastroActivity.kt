package com.example.desafio_web_services.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio_web_services.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        cadastroButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        cadastroAppBar.setNavigationOnClickListener {
            finish()
        }
    }
}