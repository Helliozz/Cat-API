package com.example.network

import android.content.SharedPreferences
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

    //     private val adapter = MovieAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.catsList.observe(this) {
            Log.d("TAG", it.toString())

            Glide.with(this)
                .load(it.images[0].imageUrl)
                .into(binding.catImageView)
            binding.urlText.text=it.images.toString()

        }

        binding.update.setOnClickListener {
            viewModel.getAllCats()
        }
    }
}