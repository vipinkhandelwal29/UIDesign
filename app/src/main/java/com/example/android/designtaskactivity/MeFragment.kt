package com.example.android.designtaskactivity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.android.designtaskactivity.databinding.FragmentMeBinding

class MeFragment:BaseFragment<FragmentMeBinding>(), AdapterView.OnItemSelectedListener {
    private lateinit var gender:String
    override fun getLayoutId() = R.layout.fragment_me

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val genderList = resources.getStringArray(R.array.Gender)
        val adapterBG = ArrayAdapter.createFromResource(
            requireActivity().applicationContext,
            R.array.Gender,
            android.R.layout.simple_spinner_item
        )

        adapterBG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapterBG
        binding.spinner.onItemSelectedListener = this


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        gender = p0!!.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}