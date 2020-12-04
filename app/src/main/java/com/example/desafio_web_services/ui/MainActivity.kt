package com.example.desafio_web_services.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio_web_services.R
import com.example.desafio_web_services.services.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HQAdapter.OnClickHQListener {

    lateinit var adapter: HQAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    val viewModel by viewModels<MainViewModel> {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HQAdapter(this)
        rv_hq.adapter = adapter
        gridLayoutManager = GridLayoutManager(this, 3)
        rv_hq.layoutManager = gridLayoutManager
        rv_hq.hasFixedSize()

        viewModel.hqs.observe(this) {
            adapter.addHqs(it)
        }

        viewModel.popListHqs()
    }

    override fun onClickHQ(position: Int) {
        var hq = viewModel.hqs.value?.get(position)
        val intent = Intent(this, HQActivity::class.java)
        intent.putExtra("hq", hq)
        startActivity(intent)
    }
}