package com.example.desafio_web_services.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio_web_services.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HQAdapter.OnClickHQListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_hq.adapter = HQAdapter(arrayListOf(), this)
        rv_hq.layoutManager = GridLayoutManager(this, 3)
        rv_hq.setHasFixedSize(true)
    }

    override fun onClickHQ(position: Int) {
        Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
    }
}