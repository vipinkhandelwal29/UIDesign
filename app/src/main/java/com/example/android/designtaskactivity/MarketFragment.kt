package com.example.android.designtaskactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.designtaskactivity.adapter.FruitAdapter
import com.example.android.designtaskactivity.bean.FruitData
import com.example.android.designtaskactivity.databinding.FragmentMarketBinding

class MarketFragment : BaseFragment<FragmentMarketBinding>() {
    override fun getLayoutId() = R.layout.fragment_market

    private var adapter: FruitAdapter? = null

    //private val fruitList = ArrayList<FruitData>()
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

        val manager = LinearLayoutManager(requireContext().applicationContext)
        binding.recyclerView.layoutManager = manager
        /*adapter = FruitAdapter(dataList)
        binding.recyclerView.adapter = adapter
*/
        adapter = FruitAdapter(dataList, totalPriceListener = {
            binding.tvTotal.text =
                "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
                    .toString() + "Rs"


        })

        binding.recyclerView.adapter = adapter

    }

}