package com.example.ceramaster.pigment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceramaster.databinding.FragmentMyPigmentsItemBinding


class MyPigmentsListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<PigmentInfo> = basePigments
) : RecyclerView.Adapter<MyPigmentsListAdapter.PigmentHolder>() {

    fun setData(data: List<PigmentInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PigmentHolder {
        val binding = FragmentMyPigmentsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PigmentHolder(binding.root)
    }


    override fun onBindViewHolder(holder: PigmentHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class PigmentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pigment: PigmentInfo) {
            FragmentMyPigmentsItemBinding.bind(itemView)
                .apply { namePigment.text = pigment.namePigment }
                .run {
                    root.setOnClickListener {
                        onItemListClickListener.onItemClickListener(pigment)
                    }
                }
        }
    }
}