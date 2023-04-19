package com.example.ceramaster.engobe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceramaster.databinding.FragmentMyEngobesItemBinding


class MyEngobesListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<EngobeInfo> = baseEngobes
) : RecyclerView.Adapter<MyEngobesListAdapter.EngobeHolder>() {

    fun setData(data: List<EngobeInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngobeHolder {
        val binding = FragmentMyEngobesItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EngobeHolder(binding.root)
    }


    override fun onBindViewHolder(holder: EngobeHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class EngobeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(engobe: EngobeInfo) {
            FragmentMyEngobesItemBinding.bind(itemView)
                .apply { nameEngobe.text = engobe.nameEngobe }
                .run {
                    root.setOnClickListener {
                        onItemListClickListener.onItemClickListener(engobe)
                    }
                }
        }
    }
}