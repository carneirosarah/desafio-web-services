package com.example.desafio_web_services.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio_web_services.R
import kotlinx.android.synthetic.main.activity_hq.*

class HQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq)

        hq_return.setOnClickListener{
            finish()
        }
    }
}