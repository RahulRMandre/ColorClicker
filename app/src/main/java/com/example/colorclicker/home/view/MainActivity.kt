package com.example.colorclicker.home.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.colorclicker.R
import com.example.colorclicker.databinding.ActivityMainBinding
import com.example.colorclicker.home.viewmodel.ColorClickerViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: ColorClickerViewModel by lazy {
        ViewModelProvider(this).get(ColorClickerViewModel::class.java)
    }

    private val adapter: ColorClickerAdapter by lazy {
        ColorClickerAdapter(viewModel)
    }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
    }

    private  val layoutManager by lazy {
        GridLayoutManager(this, 3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.adapter = adapter
        binding.lifecycleOwner = this
        binding.layoutManager=layoutManager
        initObserver()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        viewModel.numberList.observe(this, {
            adapter.notifyDataSetChanged()
        })

        viewModel.selectedPosition.observe(this, {
            binding.selectedColor.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
        })
    }
}