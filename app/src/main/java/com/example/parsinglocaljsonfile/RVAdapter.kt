package com.example.parsinglocaljsonfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(val images:ArrayList<String>):RecyclerView.Adapter<RVAdapter.RVHolder>() {
    class RVHolder (view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.RVHolder {
       return RVHolder(LayoutInflater.from(parent.context).inflate(
           R.layout.item_row,
           parent,
           false
       ))
    }

    override fun onBindViewHolder(holder: RVAdapter.RVHolder, position: Int) {
       holder.itemView.apply {
           val url=images[position]
           Glide.with(this)
               .load(url)
               .centerCrop()
               .into(imageView)
       }
    }

    override fun getItemCount()=images.size
}