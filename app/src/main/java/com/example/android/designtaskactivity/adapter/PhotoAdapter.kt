package com.example.android.designtaskactivity.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.bean.NewArrivalItem
import com.example.android.designtaskactivity.databinding.FirstLayerBinding
import com.example.android.designtaskactivity.databinding.ForthLayerBinding
import com.example.android.designtaskactivity.databinding.SecondLayerBinding
import com.example.android.designtaskactivity.databinding.ThirdLayerBinding

class PhotoAdapter(private val photoList: ArrayList<NewArrivalItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return photoList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) PhotoFirstViewHolder(
            FirstLayerBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        ) else if (viewType == 2) PhotoSecondViewHolder(
            SecondLayerBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        ) else if (viewType == 3) PhotoForthViewHolder(
            ForthLayerBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        ) else PhotoThirdViewHolder(
            ThirdLayerBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhotoFirstViewHolder) {
            val images = photoList[position].productList
            Glide.with(holder.itemCell.ivFirstImg.context)
                .load(images[0])
                .into(holder.itemCell.ivFirstImg)

            Glide.with(holder.itemCell.ivSecondImg.context)
                .load(images[1])
                .into(holder.itemCell.ivSecondImg)

            Glide.with(holder.itemCell.ivThirdImg.context)
                .load(images[2])
                .into(holder.itemCell.ivThirdImg)

        } else if (holder is PhotoSecondViewHolder) {
            val images = photoList[position].productList
            Glide.with(holder.itemCell.ivFirstImg.context)
                .load(images[0])
                .into(holder.itemCell.ivFirstImg)

            Glide.with(holder.itemCell.ivSecondImg.context)
                .load(images[1])
                .into(holder.itemCell.ivSecondImg)

        } else if (holder is PhotoThirdViewHolder) {
            val images = photoList[position].productList
            Glide.with(holder.itemCell.ivFirstImg.context)
                .load(images[0])
                .into(holder.itemCell.ivFirstImg)

            Glide.with(holder.itemCell.ivSecondImg.context)
                .load(images[1])
                .into(holder.itemCell.ivSecondImg)

            Glide.with(holder.itemCell.ivThirdImg.context)
                .load(images[2])
                .into(holder.itemCell.ivThirdImg)
        } else if (holder is PhotoForthViewHolder) {
            val images = photoList[position].productList
            Glide.with(holder.itemCell.ivFirstImg.context)
                .load(images[0])
                .into(holder.itemCell.ivFirstImg)
        }
    }

    class PhotoFirstViewHolder(val itemCell: FirstLayerBinding) :
        RecyclerView.ViewHolder(itemCell.root)

    class PhotoSecondViewHolder(val itemCell: SecondLayerBinding) :
        RecyclerView.ViewHolder(itemCell.root)

    class PhotoThirdViewHolder(val itemCell: ThirdLayerBinding) :
        RecyclerView.ViewHolder(itemCell.root)

    class PhotoForthViewHolder(val itemCell: ForthLayerBinding) :
        RecyclerView.ViewHolder(itemCell.root)

}