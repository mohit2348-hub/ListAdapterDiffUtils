package com.example.listadapterdiffutils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapterdiffutils.R
import com.example.listadapterdiffutils.model.DataItems

class DataAdapter : ListAdapter<DataItems, DataAdapter.DataViewHolder>(DiffUtils()) {

    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.textView)
        val serial = view.findViewById<TextView>(R.id.textView2)

        fun bind(item: DataItems) {
            name.text = item.name
            serial.text = item.initial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class DiffUtils : DiffUtil.ItemCallback<DataItems>() {
        override fun areItemsTheSame(oldItem: DataItems, newItem: DataItems): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItems, newItem: DataItems): Boolean {
            return oldItem == newItem
        }

    }
}