package com.example.network

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.network.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels {
        MyViewModelFactory(
            MainRepository(
                (application as MyApplication).retrofitService
            )
        )
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.catsList.observe(this) {
            Log.d("TAG", it.toString())

            Glide.with(this)
                .load(it[0].imageUrl)
                .into(binding.catImageView)
            binding.urlText.text=it[0].toString()

        }

        binding.update.setOnClickListener {
            viewModel.getAllCats()
        }
    }
}