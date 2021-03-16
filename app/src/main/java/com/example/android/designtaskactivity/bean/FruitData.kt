package com.example.android.designtaskactivity.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.android.designtaskactivity.BR


data class FruitData(val image:Int, val name:String, val price:Float, private var quantity:Int=0): BaseObservable(){
    var qty: Int
        @Bindable get() = quantity
        set(value) {
            quantity = value
            notifyPropertyChanged(BR.qty)
        }
}
