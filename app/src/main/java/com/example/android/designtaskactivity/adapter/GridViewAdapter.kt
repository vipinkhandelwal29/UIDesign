package com.example.android.designtaskactivity.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.bean.NewArrivalItem
import com.example.android.designtaskactivity.databinding.GridLayoutBinding

class GridViewAdapter(

    private val photoList: ArrayList<String>
) :
    RecyclerView.Adapter<GridViewAdapter.GridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(GridLayoutBinding.inflate((parent.context as Activity).layoutInflater, parent, false))
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
         //val images = photoList.get(position).productList
            Glide.with(holder.itemCell .ivFirstImg.context).load(photoList.get(position)).into(holder.itemCell.ivFirstImg)
            //Glide.with(holder.itemCell.ivSecondImg.context).load(images[1]).into(holder.itemCell.ivSecondImg)
            //Glide.with(holder.itemCell.ivThirdImg.context).load(images[2]).into(holder.itemCell.ivThirdImg)
            //Glide.with(holder.itemCell.ivFourImg.context).load(images[3]).into(holder.itemCell.ivFourImg)

    }
    class GridViewHolder(val itemCell: GridLayoutBinding) :
        RecyclerView.ViewHolder(itemCell.root)
}