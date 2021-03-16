package com.example.android.designtaskactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.bean.FruitData
import com.example.android.designtaskactivity.databinding.FragmentActivityBinding
import com.example.android.designtaskactivity.databinding.FruitItemCellBinding
import com.example.android.designtaskactivity.databinding.FruitItemCellTwoBinding

class ActivityFragment : BaseFragment<FragmentActivityBinding>() {

    override fun getLayoutId() = R.layout.fragment_activity

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = ArrayList<FruitData>()
        dataList.add(FruitData(R.drawable.fruit, "Apple", 20F))
        dataList.add(FruitData(R.drawable.banana, "Banana", 30F))
        dataList.add(FruitData(R.drawable.mango, "Mango", 30F))
        dataList.add(FruitData(R.drawable.fruit, "Apple", 20F))
        dataList.add(FruitData(R.drawable.banana, "Banana", 30F))
        dataList.add(FruitData(R.drawable.mango, "Mango", 30F))
        dataList.add(FruitData(R.drawable.fruit, "Apple", 20F))
        dataList.add(FruitData(R.drawable.banana, "Banana", 30F))
        dataList.add(FruitData(R.drawable.mango, "Mango", 30F))
        dataList.add(FruitData(R.drawable.fruit, "Apple", 20F))
        dataList.add(FruitData(R.drawable.banana, "Banana", 30F))
        dataList.add(FruitData(R.drawable.mango, "Mango", 30F))

        dataList.forEach { fruit ->
            val rawLayout = FruitItemCellTwoBinding.inflate(layoutInflater)
            rawLayout.fruitDetail = fruit
            binding.llOne.addView(rawLayout.root)

            Glide.with(this).load(fruit.image).circleCrop().into(rawLayout.ivUserImage)

            rawLayout.btnSub.setOnClickListener {
                if (fruit.qty > 0) {
                    fruit.qty -= 1
                    binding.tvTotal.text =
                        "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
                            .toString() + "Rs"
                }
            }

            rawLayout.btnAdd.setOnClickListener {
                if (fruit.qty < 10)
                    fruit.qty += 1
                binding.tvTotal.text =
                    "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
                        .toString() + "Rs"
            }
        }
    }
}