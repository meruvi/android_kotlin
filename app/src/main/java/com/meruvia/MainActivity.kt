package com.meruvia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meruvia.databinding.ActivityDetailBinding
import com.meruvia.databinding.ActivityMainBinding
import com.meruvia.retrofit.RetrofitActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRecycler.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }

        binding.btnQR.setOnClickListener {
            startActivity(Intent(this, QrActivity::class.java))
        }

        binding.btnMap.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        binding.btnRetrofit.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }
    }
}