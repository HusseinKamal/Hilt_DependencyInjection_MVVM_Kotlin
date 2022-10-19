package com.hussein.hilt_mvvm_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.hussein.hilt_mvvm_kotlin.databinding.ActivityMainBinding
import com.hussein.hilt_mvvm_kotlin.retrofit.NetworkResult
import com.hussein.hilt_mvvm_kotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        fetchData()
    }
    private fun fetchData() {
        mainViewModel.fetchImageResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    // bind data to the view
                    Glide.with(this).load(response.data!!.message).placeholder(R.drawable.ic_launcher_background).into(_binding.ivImage);
                }
                is NetworkResult.Error -> {
                    // show error message
                }
                is NetworkResult.Loading -> {
                    // show a progress bar
                }
            }
        }
    }
}