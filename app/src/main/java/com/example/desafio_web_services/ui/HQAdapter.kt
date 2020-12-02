package com.example.desafio_web_services.ui

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_web_services.R
import com.example.desafio_web_services.domain.HQ

class HQAdapter (private val hqs: ArrayList<HQ>, val listener: OnClickHQListener): RecyclerView.Adapter<HQAdapter.HQViewHolder>() {

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
        holder.idHQ.text = hq.id.toString()
        // holder.imageHQ.setImageBitmap(BitmapFactory.decodeStream(hq.thumbnail))
    }

    override fun getItemCount(): Int = hqs.size
}