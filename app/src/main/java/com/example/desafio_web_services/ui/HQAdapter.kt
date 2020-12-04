package com.example.desafio_web_services.ui

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_web_services.R
import com.example.desafio_web_services.domain.HQ
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.bumptech.glide.Glide
import java.io.FileNotFoundException
import java.net.URL

class HQAdapter (val listener: OnClickHQListener): RecyclerView.Adapter<HQAdapter.HQViewHolder>() {

    private val hqs = arrayListOf<HQ>()

    interface OnClickHQListener {

        fun onClickHQ(position: Int)
    }

    inner class HQViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var idHQ: TextView = itemView.findViewById(R.id.hq_id)
        var imageHQ: ImageView = itemView.findViewById(R.id.hq_image)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            val position = adapterPosition

            if (position != RecyclerView.NO_POSITION) {

                listener.onClickHQ(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQAdapter.HQViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_hq,
                parent,
                false
        )

        return HQViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HQAdapter.HQViewHolder, position: Int) {

        var hq: HQ = hqs.get(position)
        holder.idHQ.text = "# " + hq.id.toString()

        val url = hq.thumbnail.path.replace("http", "https")
        val imageUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(holder.imageHQ.context)
            .load(imageUri)
            .error(Glide.with(holder.imageHQ).load(R.mipmap.not_found_foreground))
            .into(holder.imageHQ)


    }

    override fun getItemCount(): Int = hqs.size

    fun addHqs(newHQs: ArrayList<HQ>) {
        //newHQs.forEach { it.thumbnail.path.replace("http", "https") }
        hqs.addAll(newHQs)
        notifyDataSetChanged()
    }
}