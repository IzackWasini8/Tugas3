package com.example.tugas3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val makananList: ArrayList<ItemData>):
    RecyclerView.Adapter<MyAdapter.ImageViewHolder>(){


    var onItemClick : ((ItemData) -> Unit)? = null

    class ImageViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val imageTitle : TextView = itemView.findViewById(R.id.nama)
        val asal : TextView = itemView.findViewById(R.id.asal)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return makananList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val makanan = makananList[position]
        holder.imageView.setImageResource(makanan.imageSource)
        holder.imageTitle.text = makanan.imageTitle
        holder.asal.text = makanan.asal

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(makanan)

        }
    }

}