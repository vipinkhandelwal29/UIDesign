package com.example.android.designtaskactivity.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.bean.ImageData
import com.example.android.designtaskactivity.bean.NewArrivalItem
import com.example.android.designtaskactivity.databinding.ItemCellPhotoTwoBinding

class ImageAdapter(
    private val photoList: ArrayList<String>

) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemCellPhotoTwoBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        Glide.with(holder.itemCell.ivImage.context).load(photoList[position])
            .into(holder.itemCell.ivImage)
    }
    class ImageViewHolder(val itemCell: ItemCellPhotoTwoBinding) :
        RecyclerView.ViewHolder(itemCell.root)
}