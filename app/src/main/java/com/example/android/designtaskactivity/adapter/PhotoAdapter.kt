package com.example.android.designtaskactivity.adapter

import android.app.Activity
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.databinding.ItemPhotoCellBinding

class PhotoAdapter(private val photoList: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(

    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoViewHolder(
            ItemPhotoCellBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhotoViewHolder){
            holder.itemcellBinding.data = photoList[position]
            /*Glide.with(holder.itemcellBinding.ivUserPhoto.context)
                .load(photoList[position].user_image).circleCrop()
                .into(holder.itemcellBinding.ivUserPhoto)*/



        }

    }

    class PhotoViewHolder(val itemcellBinding: ItemPhotoCellBinding) :
        RecyclerView.ViewHolder(itemcellBinding.root)

}