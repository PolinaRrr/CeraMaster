package com.example.ceramaster.glaze

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceramaster.databinding.FragmentMyGlazesItemBinding


class MyGlazesListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<GlazeInfo> = listOf()
) : RecyclerView.Adapter<MyGlazesListAdapter.GlazeHolder>() {

    fun setData(data: List<GlazeInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlazeHolder {
        val binding = FragmentMyGlazesItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GlazeHolder(binding.root)
    }


    override fun onBindViewHolder(holder: GlazeHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class GlazeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(glaze: GlazeInfo) {
            FragmentMyGlazesItemBinding.bind(itemView)
                .apply { nameGlaze.text = glaze.nameGlaze }
                .run {
                    root.setOnClickListener {
                        onItemListClickListener.onItemClickListener(glaze)
                    }
                }
        }
    }
}