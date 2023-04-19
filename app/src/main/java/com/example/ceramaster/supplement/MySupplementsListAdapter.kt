package com.example.ceramaster.supplement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceramaster.databinding.FragmentMySupplementsItemBinding


class MySupplementsListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<SupplementInfo> = baseSupplements
) : RecyclerView.Adapter<MySupplementsListAdapter.SupplementHolder>() {

    fun setData(data: List<SupplementInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplementHolder {
        val binding = FragmentMySupplementsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SupplementHolder(binding.root)
    }


    override fun onBindViewHolder(holder: SupplementHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class SupplementHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(supplement: SupplementInfo) {
            FragmentMySupplementsItemBinding.bind(itemView)
                .apply { nameSupplement.text = supplement.nameSupplement }
                .run {
                    root.setOnClickListener {
                        onItemListClickListener.onItemClickListener(supplement)
                    }
                }
        }
    }
}