package com.meruvia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meruvia.adapter.SuperHeroAdapter
import com.meruvia.databinding.ActivityDetailBinding
import com.meruvia.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        binding.rvSuperHero.layoutManager = manager
        binding.rvSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList) { superHero ->
            onItemSelected(
                superHero
            )
        }
    }

    fun onItemSelected(superHero: SuperHero){
        Toast.makeText(this, superHero.name, Toast.LENGTH_SHORT).show()
    }
}