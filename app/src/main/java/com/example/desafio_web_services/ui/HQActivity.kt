package com.example.desafio_web_services.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.desafio_web_services.R
import com.example.desafio_web_services.domain.HQ
import kotlinx.android.synthetic.main.activity_hq.*

class HQActivity : AppCompatActivity() {

    val viewModel: HQViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq)

        viewModel.setHQ(intent.extras?.get("hq") as HQ)

        var url = viewModel.hq.value?.thumbnail!!.path.replace("http", "https") + "/landscape_incredible." + viewModel.hq.value?.thumbnail!!.extension
        var imageUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(hq_background.context)
                .load(imageUri)
                .into(hq_background)
        url = viewModel.hq.value?.thumbnail!!.path.replace("http", "https") + "/portrait_fantastic." + viewModel.hq.value?.thumbnail!!.extension
        imageUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(hq_image.context)
                .load(imageUri)
                .into(hq_image)
        hq_title.text = viewModel.hq.value?.title
        hq_description.text = viewModel.hq.value?.description
        hq_published.text = viewModel.hq.value?.dates!![0].date
        hq_price.text = viewModel.hq.value?.prices!![0].price.toString()
        hq_pages.text = viewModel.hq.value?.pageCount.toString()


        hq_return.setOnClickListener{
            finish()
        }
    }
}