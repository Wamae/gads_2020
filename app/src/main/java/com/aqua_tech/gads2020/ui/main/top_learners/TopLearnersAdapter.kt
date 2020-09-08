package com.aqua_tech.gads2020.ui.main.top_learners

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.ui.main.TopLearner


class TopLearnersAdapter(private val topLearners: MutableList<TopLearner>) :
    RecyclerView.Adapter<TopLearnersAdapter.TopLearnerViewHolder>() {
    inner class TopLearnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivTopLearner: ImageView = itemView.findViewById(R.id.iv_top_learner)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvSubTitle: TextView = itemView.findViewById(R.id.tv_sub_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopLearnersAdapter.TopLearnerViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val topLearnerView: View = inflater.inflate(R.layout.item_top_learners, parent, false)
        return TopLearnerViewHolder(topLearnerView)
    }

    override fun onBindViewHolder(holder: TopLearnerViewHolder, position: Int) {
        val topLearner = topLearners[position]
        holder.tvTitle.text = topLearner.name
        holder.tvSubTitle.text = "${topLearner.hours} learning hours, Kenya."
    }

    override fun getItemCount() = topLearners.size
}