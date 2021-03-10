package com.example.android.designtaskactivity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.designtaskactivity.adapter.PhotoAdapter
import com.example.android.designtaskactivity.databinding.FragmentFeedBinding

class FeedFragment:BaseFragment<FragmentFeedBinding>() {
    override fun getLayoutId() = R.layout.fragment_feed

    private var adapter: PhotoAdapter?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<String>()
        imageList.add("https://randomuser.me/api/portraits/men/37.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/0.jpg")
        imageList.add("https://randomuser.me/api/portraits/women/86.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/32.jpg")
        imageList.add("https://randomuser.me/api/portraits/women/4.jpg")
        imageList.add("https://randomuser.me/api/portraits/women/79.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/51.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/37.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/0.jpg")
        imageList.add("https://randomuser.me/api/portraits/women/86.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/32.jpg")
        imageList.add("https://randomuser.me/api/portraits/women/4.jpg")
        imageList.add("https://randomuser.me/api/portraits/women/79.jpg")
        imageList.add("https://randomuser.me/api/portraits/men/51.jpg")

        val manager = LinearLayoutManager(requireContext().applicationContext)
        binding.recyclerView.layoutManager = manager

        adapter = PhotoAdapter(imageList)

        binding.recyclerView.adapter = adapter

    }
}