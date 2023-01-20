package com.meruvia.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.meruvia.SuperHero
import com.meruvia.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view:View):ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)

    fun render(superHero: SuperHero, onClickListener:(SuperHero) -> Unit){
        binding.tvName.text = superHero.name
        binding.tvRealName.text = superHero.realName
        binding.tvPublisher.text = superHero.publisher
        Glide.with(binding.ivPhoto.context).load(superHero.photo).into(binding.ivPhoto)

        itemView.setOnClickListener {
            onClickListener(superHero)
        }
    }
}