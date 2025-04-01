package com.example.umc8th

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc8th.databinding.ItemHomePanelBinding

data class PanelData(
    val title: String,
    val backgroundResId: Int
)

class PanelAdapter(private val panels: List<PanelData>) : RecyclerView.Adapter<PanelAdapter.PanelViewHolder>() {

    inner class PanelViewHolder(private val binding: ItemHomePanelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PanelData) {
            binding.panelTitle.text = data.title
            binding.panelBackground.setImageResource(data.backgroundResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelViewHolder {
        val binding = ItemHomePanelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PanelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PanelViewHolder, position: Int) {
        holder.bind(panels[position])
    }

    override fun getItemCount() = panels.size
}
