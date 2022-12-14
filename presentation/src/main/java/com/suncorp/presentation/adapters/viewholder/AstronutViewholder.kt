package com.suncorp.presentation.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suncorp.databinding.ItemAstronutBinding
import com.suncorp.domain.model.models.Astronut

/**
 * [RecyclerView.ViewHolder] implementation to inflate View for RecyclerView.
 * See AstronutListAdapter
 */
class AstronutViewholder(private val binding: ItemAstronutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(astronut: Astronut, onItemClicked: (Astronut) -> Unit) {

        binding.apply{
            tvName.text = astronut.name
            tvNationality.text = astronut.nationality

            Glide.with(ivImage.context)
                .load(astronut.profile_image) // image url
                .into(ivImage)

            root.setOnClickListener {
                onItemClicked(astronut)
            }
        }

    }
}
