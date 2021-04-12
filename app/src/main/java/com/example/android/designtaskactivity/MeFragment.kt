package com.example.android.designtaskactivity

import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.designtaskactivity.adapter.ImageAdapter
import com.example.android.designtaskactivity.bean.ImageData
import com.example.android.designtaskactivity.bean.NewArrivalItem
import com.example.android.designtaskactivity.databinding.FragmentMeBinding
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

class MeFragment : BaseFragment<FragmentMeBinding>() {

    override fun getLayoutId() = R.layout.fragment_me

    private var adapter: ImageAdapter? = null

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

        //val manager = LinearLayoutManager(requireContext().applicationContext)
        val gridLayoutManager = GridLayoutManager(requireContext().applicationContext, 2)

        val rectangle = Rect()
        requireActivity().window.decorView.getWindowVisibleDisplayFrame(rectangle)

        val statusBarHeight = rectangle.top
        binding.appbarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxOffSet =
                binding.appbarLayout.height - binding.toolbarView.height - statusBarHeight
            val offSet = 1f - abs(verticalOffset / maxOffSet.toFloat())

            if ((1f - offSet) == 0f) {
                requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE;
            } else {
                requireActivity().window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }

            binding.linearLayout.alpha = offSet
            val minHeight = resources.getDimensionPixelSize(R.dimen.dimen_36dp)
            val maxHeight = resources.getDimensionPixelSize(R.dimen.dimen_75dp)
            val diff = maxHeight - minHeight
            val params = binding.ivAccCircle.layoutParams
            val size = (minHeight + (diff * offSet)).toInt()
            params.width = size
            params.height = size
            binding.ivAccCircle.layoutParams = params

            val minStarHeight = resources.getDimensionPixelSize(R.dimen.dimen_20dp)
            val maxStarHeight = resources.getDimensionPixelSize(R.dimen.dimen_24dp)
            val diffStar = maxStarHeight - minStarHeight
            binding.ivSetting.alpha = offSet

            val color = Color.argb(
                255,
                (255 * offSet).toInt(),
                (255 * offSet).toInt(),
                (255 * offSet).toInt()
            )
            Log.d("==>color", "$color")

            binding.tvElinas.setTextColor(color)
            binding.tvRating.setTextColor(color)
            DrawableCompat.setTint(binding.ivCart.drawable, Color.argb(
                255,
                (255 * offSet).toInt(),
                (255 * offSet).toInt(),
                (255 * offSet).toInt()))

            val minText = resources.getDimension(R.dimen.dimen_12sp)
            Log.d("==>", "$minText")
            val maxText = resources.getDimension(R.dimen.dimen_14sp)
            Log.d("==>", "$maxText")
            val diffText = maxText - minText

            val minElText = resources.getDimension(R.dimen.dimen_14sp)
            val maxElText = resources.getDimension(R.dimen.dimen_18sp)
            val diffEl = maxElText - minElText
            binding.tvElinas.setTextSize(
                TypedValue.COMPLEX_UNIT_PX, minElText + (diffEl * offSet)
            )

            binding.tvRating.setTextSize(TypedValue.COMPLEX_UNIT_PX, minText + (diffText * offSet))

            val maxDrawHeight = resources.getDimension(R.dimen.dimen_24dp)
            val minDrawHeight = resources.getDimension(R.dimen.dimen_16dp)
            val diffDrawHeight = maxDrawHeight - minDrawHeight

            val density = resources.displayMetrics.density
            val drawable = resources.getDrawable(R.drawable.ic_baseline_star_24)
            val height = (minDrawHeight + (diffDrawHeight * offSet)).toInt()
            drawable.setBounds(0, 0, height, height)
            binding.tvRating.setCompoundDrawables(drawable, null, null, null)


            val maxMarginTop = resources.getDimension(R.dimen.dimen_89dp)
            val minMarginTop = resources.getDimension(R.dimen.dimen_36dp)
            val diffMarginTop = maxMarginTop - minMarginTop

            val maxMarginStart = resources.getDimension(R.dimen.dimen_60dp)
            val minMarginStart = resources.getDimension(R.dimen.dimen_20dp)
            val diffMarginStart = maxMarginStart - minMarginStart
            Log.d("==>start", "$maxMarginStart")
            Log.d("==>start", "$minMarginStart")

            val paramsConstraint =
                binding.constraintLayout.layoutParams as CoordinatorLayout.LayoutParams

            paramsConstraint.topMargin = (minMarginTop + (diffMarginTop * offSet)).toInt()
            paramsConstraint.marginStart =
                (minMarginStart + (diffMarginStart * (1 - offSet))).toInt()
            binding.constraintLayout.layoutParams = paramsConstraint
        })

        binding.recyclerView.layoutManager = gridLayoutManager
        adapter = ImageAdapter(imageList)
        binding.recyclerView.adapter = adapter
        Log.d("==>", "$adapter")
    }
}