package com.example.ceramaster.probe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceramaster.databinding.FragmentMyProbesItemBinding


class MyProbesListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<ProbeInfo> = baseProbes
) : RecyclerView.Adapter<MyProbesListAdapter.ProbeHolder>() {

    fun setData(data: List<ProbeInfo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProbeHolder {
        val binding = FragmentMyProbesItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProbeHolder(binding.root)
    }


    override fun onBindViewHolder(holder: ProbeHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class ProbeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(probe: ProbeInfo) {
            FragmentMyProbesItemBinding.bind(itemView)
                .apply {
                    "${probe.nameClays} ${probe.nameGlazes}".also { nameProbe.text = it }

                }
                .run {
                    root.setOnClickListener {
                        onItemListClickListener.onItemClickListener(probe)
                    }
                }
        }
    }
}