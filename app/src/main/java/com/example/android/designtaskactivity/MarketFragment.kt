package com.example.android.designtaskactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.designtaskactivity.adapter.FruitAdapter
import com.example.android.designtaskactivity.bean.FruitData
import com.example.android.designtaskactivity.databinding.FragmentMarketBinding

class MarketFragment : BaseFragment<FragmentMarketBinding>() {
    override fun getLayoutId() = R.layout.fragment_market

    private var adapter: FruitAdapter? = null
    private val dataList = ArrayList<FruitData>()
    private var discount = ObservableField<Double>(0.0)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataList.add(FruitData(R.drawable.fruit, "Apple", 20F,))
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

        val manager = LinearLayoutManager(requireContext().applicationContext)
        binding.recyclerView.layoutManager = manager

        adapter = FruitAdapter(dataList, totalPriceListener = {
            updatePrice()
        }, callEdit = { textView ->
            binding.rdGroup.setOnCheckedChangeListener { group, checkedId ->
                val radioButton = checkedId
                if (binding.rdNone.isChecked) {
                    discount.set(0.0)
                } else if (binding.rdTen.isChecked) {
                    discount.set(0.1)
                } else if (binding.rdTwenty.isChecked) {
                    discount.set(0.2)
                } else if (binding.rdThirty.isChecked) {
                    discount.set(0.3)
                }
                updatePrice()
            }
            textView.text = dataList.sumByDouble {
                (it.price * it.qty) - (it.price * it.qty * discount.get()!!)
            }.toString()
        })
        binding.recyclerView.adapter = adapter
    }


    @SuppressLint("SetTextI18n")
    private fun updatePrice() {
        binding.tvTotal.text =
            "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (it.price.toDouble() * it.qty * discount.get()!!) }
                .toString() + "Rs"
    }
}