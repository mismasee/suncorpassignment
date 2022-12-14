package com.suncorp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suncorp.databinding.ItemAstronutBinding
import com.suncorp.domain.model.models.Astronut
import com.suncorp.presentation.adapters.viewholder.AstronutViewholder

/**
 * Adapter class [RecyclerView.Adapter] for [RecyclerView] which binds [Astronut] along with [AstronutViewholder]
 * @param onItemClicked which will receive callback when item is clicked.
 */
class AstronutListAdapter(
    private val onItemClicked: (Astronut) -> Unit
) : ListAdapter<Astronut, AstronutViewholder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AstronutViewholder(
        ItemAstronutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AstronutViewholder, position: Int) =
        holder.bind(getItem(position),onItemClicked)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Astronut>() {
            override fun areItemsTheSame(oldItem: Astronut, newItem: Astronut): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Astronut, newItem: Astronut): Boolean =
                oldItem == newItem
        }
    }
}
