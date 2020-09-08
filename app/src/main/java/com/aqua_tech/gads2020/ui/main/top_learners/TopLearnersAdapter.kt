package com.aqua_tech.gads2020.ui.main.top_learners

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aqua_tech.gads2020.R

class TopLearnersAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<TopLearnersAdapter.MyViewHolder>() {
    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopLearnersAdapter.MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leader, parent, false) as TextView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size
}