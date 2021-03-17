package com.example.android.designtaskactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide
import com.example.android.designtaskactivity.bean.FruitData
import com.example.android.designtaskactivity.databinding.FragmentActivityBinding
import com.example.android.designtaskactivity.databinding.FruitItemCellTwoBinding


class ActivityFragment : BaseFragment<FragmentActivityBinding>() {

    override fun getLayoutId() = R.layout.fragment_activity

    private val dataList = ArrayList<FruitData>()
    private var discount = ObservableField<Double>(0.0)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            rawLayout.discount = discount.get()!!.toFloat()
            discount.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    rawLayout.discount = discount.get()!!.toFloat()
                }
            })


            binding.llOne.addView(rawLayout.root)

            Glide.with(this).load(fruit.image).circleCrop().into(rawLayout.ivUserImage)

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


            rawLayout.btnSub.setOnClickListener {
                if (fruit.qty > 0) {
                    fruit.qty -= 1
                }
                updatePrice()
            }

            rawLayout.btnAdd.setOnClickListener {
                if (fruit.qty < 10) {
                    fruit.qty += 1
                }
                updatePrice()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updatePrice() {
        binding.tvTotal.text =
            "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (it.price.toDouble() * it.qty * discount.get()!!) }
                .toString() + "Rs"
    }

}

/* rawLayout.tvTotatAmount.text =
                ("Total Price = " + fruit.price.toDouble() * fruit.qty + "Rs")
            rawLayout.tvDiscountAmount.text =
                "D-Price= " + fruit.price.toDouble() * fruit.qty + "Rs"*/
/* binding.tvTotal.text =
     "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
         .toString() + "Rs"*/
/* if (binding.rdNone.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
             .toString() + "Rs"
 } else if (binding.rdTen.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (((it.price.toDouble() * it.qty) * 10)/100) }
             .toString() + "Rs"
 } else if (binding.rdTwenty.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (((it.price.toDouble() * it.qty) * 20)/100) }
             .toString() + "Rs"
 } else if (binding.rdThiry.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (((it.price.toDouble() * it.qty) * 30)/100) }
             .toString() + "Rs"
 }*/
/*rawLayout.tvTotatAmount.text =
                   ("Total Price = " + fruit.price.toDouble() * fruit.qty + "Rs")

               rawLayout.tvDiscountAmount.text =
                   "D-Price= " + fruit.price.toDouble() * fruit.qty + "Rs"*/
/*  binding.tvTotal.text =
      "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
          .toString() + "Rs"*/
/*binding.rdGroup.setOnCheckedChangeListener { group, checkedId ->
    val radioButton = checkedId
    if (binding.rdNone.isChecked) {
        binding.tvTotal.text =
            "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
                .toString() + "Rs"

    } else if (binding.rdTen.isChecked) {
        binding.tvTotal.text =
            "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - ((it.price.toDouble() * it.qty) * discount) }
                .toString() + "Rs"
    } else if (binding.rdTwenty.isChecked) {
        binding.tvTotal.text =
            "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - ((it.price.toDouble() * it.qty) * discount) }
                .toString() + "Rs"
    } else if (binding.rdThirty.isChecked) {

    }

}*/
/*when (radioButton) {
    R.id.rdNone -> {
        if (binding.rdNone.isChecked) {
            updatePrice()
            rawLayout.tvDiscountAmount.text =
                "D-Price= " + fruit.price.toDouble() * fruit.qty + "Rs"
        }
    }

    R.id.rdTen -> {
        if (binding.rdTen.isChecked) {
            rawLayout.tvDiscountAmount.text =
                ("D-Price = " + ((fruit.price.toDouble() * fruit.qty) - ((fruit.price.toDouble() * fruit.qty) * 10) / 100) + "Rs")

        }
    }

    R.id.rdTwenty -> {
        if (binding.rdTwenty.isChecked) {
            rawLayout.tvDiscountAmount.text =
                ("D-Price = " + ((fruit.price.toDouble() * fruit.qty) - ((fruit.price.toDouble() * fruit.qty) * 20) / 100) + "Rs")
        }
    }
    R.id.rdThirty -> {
        if (binding.rdThirty.isChecked) {
            rawLayout.tvDiscountAmount.text =
                ("D-Price = " + ((fruit.price.toDouble() * fruit.qty) - ((fruit.price.toDouble() * fruit.qty) * 30) / 100) + "Rs")
        }
    }
}*/
/* if (binding.rdNone.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { it.price.toDouble() * it.qty }
             .toString() + "Rs"

 } else if (binding.rdTen.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (((it.price.toDouble() * it.qty) * 10)/100) }
             .toString() + "Rs"
 } else if (binding.rdTwenty.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (((it.price.toDouble() * it.qty) * 20)/100) }
             .toString() + "Rs"
 } else if (binding.rdThiry.isChecked) {
     binding.tvTotal.text =
         "Total Price = " + dataList.sumByDouble { (it.price.toDouble() * it.qty) - (((it.price.toDouble() * it.qty) * 30)/100) }
             .toString() + "Rs"
 }*/
/* when (radioButton) {

                     R.id.rdNone -> {
                         if (binding.rdNone.isChecked) {
                             rawLayout.tvDiscountAmount.text =
                                 "D-Price= " + fruit.price.toDouble() * fruit.qty + "Rs"
                         }
                     }

                     R.id.rdTen -> {
                         if (binding.rdTen.isChecked) {
                             rawLayout.tvDiscountAmount.text =
                                 ("D-Price = " + ((fruit.price.toDouble() * fruit.qty) - ((fruit.price.toDouble() * fruit.qty) * 10) / 100) + "Rs")
                         }
                     }

                     R.id.rdTwenty -> {
                         if (binding.rdTwenty.isChecked) {
                             rawLayout.tvDiscountAmount.text =
                                 ("D-Price = " + ((fruit.price.toDouble() * fruit.qty) - ((fruit.price.toDouble() * fruit.qty) * 20) / 100) + "Rs")
                         }
                     }
                     R.id.rdThirty -> {
                         if (binding.rdThirty.isChecked) {
                             rawLayout.tvDiscountAmount.text =
                                 ("D-Price = " + ((fruit.price.toDouble() * fruit.qty) - ((fruit.price.toDouble() * fruit.qty) * 20) / 100) + "Rs")
                         }
                     }
                 }*/