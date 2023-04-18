package com.example.ceramaster.glaze

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceramaster.databinding.FragmentMyClaysItemBinding


class MyGlazesListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<GlazeInfo> = baseGlazes
) : RecyclerView.Adapter<MyGlazesListAdapter.ClayHolder>() {

    fun setData(data: List<GlazeInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClayHolder {
        val binding = FragmentMyClaysItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClayHolder(binding.root)
    }


    override fun onBindViewHolder(holder: ClayHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class ClayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(clay: GlazeInfo) {
            FragmentMyClaysItemBinding.bind(itemView)
                .apply { nameClay.text = clay.nameGlaze }
                .run {
                    root.setOnClickListener {
                        onItemListClickListener.onItemClickListener(clay)
                    }
                }
        }
    }
}