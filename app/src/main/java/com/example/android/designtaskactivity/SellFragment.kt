package com.example.android.designtaskactivity

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.INFINITE
import android.view.animation.Animation.REVERSE
import android.view.animation.TranslateAnimation
import com.example.android.designtaskactivity.databinding.FragmentSellBinding
import kotlin.math.cos
import kotlin.math.sin


class SellFragment : BaseFragment<FragmentSellBinding>() {
    override fun getLayoutId() = R.layout.fragment_sell
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageRadius =
            (resources.getDimension(R.dimen.dimen_320dp) - resources.getDimension(R.dimen.dimen_16dp)) / 2


        val fromX1 = imageRadius * sin(22.5 * (Math.PI) / 180)
        val fromY1 = imageRadius * cos(22.5 * (Math.PI) / 180)
        val toX1 = imageRadius * sin((22.5 + 180) * (Math.PI) / 180)
        val toY1 = imageRadius * cos((22.5 + 180) * (Math.PI) / 180)

        val animation2: Animation =
            TranslateAnimation(fromX1.toFloat(), toX1.toFloat(), fromY1.toFloat(), toY1.toFloat())
        animation2.duration = 2000
        animation2.fillAfter = true
        animation2.repeatMode = REVERSE
        animation2.repeatCount = INFINITE
        Thread {
            Thread.sleep(250)
            binding.ivImageTwo.startAnimation(animation2)
        }.start()


        val fromX2 = imageRadius * sin(45 * (Math.PI) / 180)
        val fromY2 = imageRadius * cos(45 * (Math.PI) / 180)
        val toX2 = imageRadius * sin((45 + 180) * (Math.PI) / 180)
        val toY2 = imageRadius * cos((45 + 180) * (Math.PI) / 180)

        val animation3: Animation =
            TranslateAnimation(fromX2.toFloat(), toX2.toFloat(), fromY2.toFloat(), toY2.toFloat())
        animation3.duration = 2000
        animation3.fillAfter = true
        animation3.repeatMode = REVERSE
        animation3.repeatCount = INFINITE
        Thread {
            Thread.sleep(500)
            binding.ivImageThree.startAnimation(animation3)
        }.start()


        val fromX4 = imageRadius * sin(67.5 * (Math.PI) / 180)
        val fromY4 = imageRadius * cos(67.5 * (Math.PI) / 180)
        val toX4 = imageRadius * sin((67.5 + 180) * (Math.PI) / 180)
        val toY4 = imageRadius * cos((67.5 + 180) * (Math.PI) / 180)

        val animation4: Animation =
            TranslateAnimation(fromX4.toFloat(), toX4.toFloat(), fromY4.toFloat(), toY4.toFloat())
        animation4.duration = 2000
        animation4.fillAfter = true
        animation4.repeatMode = REVERSE
        animation4.repeatCount = INFINITE
        Thread {
            Thread.sleep(750)
            binding.ivImageFour.startAnimation(animation4)
        }.start()


        val fromX5 = imageRadius * sin(90 * (Math.PI) / 180)
        val fromY5 = imageRadius * cos(90 * (Math.PI) / 180)
        val toX5 = imageRadius * sin((90 + 180) * (Math.PI) / 180)
        val toY5 = imageRadius * cos((90 + 180) * (Math.PI) / 180)

        val animation5: Animation =
            TranslateAnimation(fromX5.toFloat(), toX5.toFloat(), fromY5.toFloat(), toY5.toFloat())
        animation5.duration = 2000
        animation5.fillAfter = true
        animation5.repeatMode = REVERSE
        animation5.repeatCount = INFINITE
        Thread {
            Thread.sleep(1000)
            binding.ivImageFive.startAnimation(animation5)
        }.start()


        val fromX6 = imageRadius * sin(112.5 * (Math.PI) / 180)
        val fromY6 = imageRadius * cos(112.5 * (Math.PI) / 180)
        val toX6 = imageRadius * sin((112.5 + 180) * (Math.PI) / 180)
        val toY6 = imageRadius * cos((112.5 + 180) * (Math.PI) / 180)

        val animation6: Animation =
            TranslateAnimation(fromX6.toFloat(), toX6.toFloat(), fromY6.toFloat(), toY6.toFloat())
        animation6.duration = 2000
        animation6.fillAfter = true
        animation6.repeatMode = REVERSE
        animation6.repeatCount = INFINITE
        Thread {
            Thread.sleep(1250)
            binding.ivImageSix.startAnimation(animation6)
        }.start()


        val fromX7 = imageRadius * sin(135 * (Math.PI) / 180)
        val fromY7 = imageRadius * cos(135 * (Math.PI) / 180)
        val toX7 = imageRadius * sin((135 + 180) * (Math.PI) / 180)
        val toY7 = imageRadius * cos((135 + 180) * (Math.PI) / 180)

        val animation7: Animation =
            TranslateAnimation(fromX7.toFloat(), toX7.toFloat(), fromY7.toFloat(), toY7.toFloat())
        animation7.duration = 2000
        animation7.fillAfter = true
        animation7.repeatMode = REVERSE
        animation7.repeatCount = INFINITE
        Thread {
            Thread.sleep(1500)
            binding.ivImageSeven.startAnimation(animation7)
        }.start()


        val fromX8 = imageRadius * sin(157.5 * (Math.PI) / 180)
        val fromY8 = imageRadius * cos(157.5 * (Math.PI) / 180)
        val toX8 = imageRadius * sin((157.5 + 180) * (Math.PI) / 180)
        val toY8 = imageRadius * cos((157.5 + 180) * (Math.PI) / 180)

        val animation8: Animation =
            TranslateAnimation(fromX8.toFloat(), toX8.toFloat(), fromY8.toFloat(), toY8.toFloat())
        animation8.duration = 2000
        animation8.fillAfter = true
        animation8.repeatMode = REVERSE
        animation8.repeatCount = INFINITE
        Thread {
            Thread.sleep(1750)
            binding.ivImageEight.startAnimation(animation8)
        }.start()


        val fromX = imageRadius * sin(180 * (Math.PI) / 180)
        val fromY = imageRadius * cos(180 * (Math.PI) / 180)
        val toX = imageRadius * sin((180 + 180) * (Math.PI) / 180)
        val toY = imageRadius * cos((180 + 180) * (Math.PI) / 180)

        val animation1: Animation =
            TranslateAnimation(fromX.toFloat(), toX.toFloat(), fromY.toFloat(), toY.toFloat())
        animation1.duration = 2000
        animation1.fillAfter = true
        animation1.repeatMode = REVERSE
        animation1.repeatCount = INFINITE
        Thread {
            Thread.sleep(2000)
            binding.ivImageOne.startAnimation(animation1)
        }.start()
    }

}