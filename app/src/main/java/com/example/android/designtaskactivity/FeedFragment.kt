package com.example.android.designtaskactivity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.designtaskactivity.adapter.PhotoAdapter
import com.example.android.designtaskactivity.bean.NewArrivalItem
import com.example.android.designtaskactivity.databinding.FragmentFeedBinding

class FeedFragment : BaseFragment<FragmentFeedBinding>() {
    override fun getLayoutId() = R.layout.fragment_feed

    private var adapter: PhotoAdapter? = null
    private lateinit var photoList: ArrayList<NewArrivalItem>
    private lateinit var newItem: NewArrivalItem

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
        /*  imageList.add("https://randomuser.me/api/portraits/women/86.jpg")
          imageList.add("https://randomuser.me/api/portraits/men/32.jpg")
          imageList.add("https://randomuser.me/api/portraits/women/4.jpg")
          imageList.add("https://randomuser.me/api/portraits/women/79.jpg")*/
        /*imageList.add("https://randomuser.me/api/portraits/men/51.jpg")*/

        val dataList = ArrayList<NewArrivalItem>()
        val manager = LinearLayoutManager(requireContext().applicationContext)
        binding.recyclerView.layoutManager = manager
        adapter = PhotoAdapter(dataList)
        binding.recyclerView.adapter = adapter

        var total = imageList.size
        while (total > 0) {
            if (dataList.isEmpty()) {
                when {
                    total >= 3 -> {
                        val mediaList = arrayListOf<String>()
                        for (i in 0..2) {
                            mediaList.add(imageList[0])
                            imageList.removeAt(0)
                        }
                        dataList.add(NewArrivalItem(3, 1, mediaList))
                        total -= 3

                    }
                    total == 2 -> {
                        val mediaList = arrayListOf<String>()
                        for (i in 0..1) {
                            mediaList.add(imageList[0])
                            imageList.removeAt(0)
                        }
                        dataList.add(NewArrivalItem(2, 2, mediaList))
                        total -= 2
                    }
                    else -> {
                        val mediaList = arrayListOf<String>()
                        mediaList.add(imageList[0])
                        imageList.removeAt(0)
                        dataList.add(NewArrivalItem(1, 3, mediaList))
                        total -= 1
                    }
                }
            } else {
                val lastType = dataList.last()!!.type
                val secondLastType = if (dataList.size > 1) dataList[dataList.size - 2]!!.type else -1
                when {
                    total >= 3 -> {
                        when (lastType) {
                            1, 4 -> {
                                val mediaList = arrayListOf<String>()
                                for (i in 0..1) {
                                    mediaList.add(imageList[0])
                                    imageList.removeAt(0)
                                }
                                dataList.add(NewArrivalItem(2, 2, mediaList))
                                total -= 2
                            }
                            2 -> {
                                val mediaList = arrayListOf<String>()
                                if (secondLastType == 1) {
                                    for (i in 0..2) {
                                        mediaList.add(imageList[0])
                                        imageList.removeAt(0)
                                    }
                                    dataList.add(NewArrivalItem(3, 4, mediaList))
                                    total -= 3
                                } else {
                                    for (i in 0..2) {
                                        mediaList.add(imageList[0])
                                        imageList.removeAt(0)
                                    }
                                    dataList.add(NewArrivalItem(3, 1, mediaList))
                                    total -= 3

                                }
                            }
                        }
                    }
                    total == 2 -> {
                        val mediaList = arrayListOf<String>()
                        for (i in 0..1) {
                            mediaList.add(imageList[0])
                            imageList.removeAt(0)
                        }
                        dataList.add(NewArrivalItem(2, 2, mediaList))
                        total -= 2
                    }
                    else -> {
                        val mediaList = arrayListOf<String>()
                        mediaList.add(imageList[0])
                        imageList.removeAt(0)
                        dataList.add(NewArrivalItem(1, 3, mediaList))
                        total -= 1
                    }
                }
            }
        }

        adapter!!.notifyDataSetChanged()

    }
}