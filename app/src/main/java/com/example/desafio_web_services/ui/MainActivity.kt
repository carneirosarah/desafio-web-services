package com.example.desafio_web_services.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    var offset = 1

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

        viewModel.popListHqs(offset)
        offset++

        setScroller()
    }

    override fun onClickHQ(position: Int) {
        var hq = viewModel.hqs.value?.get(position)
        val intent = Intent(this, HQActivity::class.java)
        intent.putExtra("hq", hq)
        startActivity(intent)
    }

    fun setScroller(){
        rv_hq.addOnScrollListener(object: RecyclerView.OnScrollListener () {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0) {
                    val lItem = gridLayoutManager.itemCount
                    val vItem = gridLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val itens = adapter.itemCount

                    if (lItem + vItem > itens) {
                        viewModel.popListHqs(offset)
                        offset++
                    }
                }
            }
        })
    }
}