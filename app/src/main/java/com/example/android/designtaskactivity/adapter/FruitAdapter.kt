package com.example.android.designtaskactivity.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.bean.FruitData
import com.example.android.designtaskactivity.databinding.FruitItemCellBinding

class FruitAdapter(
    private val fruitList: ArrayList<FruitData>,
    private val totalPriceListener: () -> Unit
) :
    RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(
            FruitItemCellBinding.inflate(
                (parent.context as Activity).layoutInflater,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = fruitList.size

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {

        holder.itemCell.fruitDetail = this.fruitList[position]
        Glide.with(holder.itemCell.ivUserImage).load(fruitList[position].image)
            .circleCrop().into(holder.itemCell.ivUserImage)

        holder.itemCell.btnSub.setOnClickListener {
            if (fruitList[holder.adapterPosition].qty > 0) {
                fruitList[holder.adapterPosition].qty -= 1
                totalPriceListener()
            }
        }

        holder.itemCell.btnAdd.setOnClickListener {
            if (fruitList[holder.adapterPosition].qty < 10)
                fruitList[holder.adapterPosition].qty += 1
            totalPriceListener()
        }
    }


    class FruitViewHolder(val itemCell: FruitItemCellBinding) :
        RecyclerView.ViewHolder(itemCell.root)
}