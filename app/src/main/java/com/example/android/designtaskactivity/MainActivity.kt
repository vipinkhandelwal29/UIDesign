package com.example.android.designtaskactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.designtaskactivity.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutId() = R.layout.activity_main

    override fun initControl() {

        binding.selected = 1
        binding.tvFeed.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flRoot, FeedFragment()).commit()
            binding.selected = 1
        }
        binding.tvMarket.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flRoot, MarketFragment())
                .commit()
            binding.selected = 2
        }
        binding.tvSell.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flRoot, SellFragment())
                .commit()
            binding.selected = 3
        }
        binding.tvActivity.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flRoot, ActivityFragment()).commit()
            binding.selected = 4
        }
        binding.tvMe.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flRoot, MeFragment()).commit()
            binding.selected = 5
        }
    }
}