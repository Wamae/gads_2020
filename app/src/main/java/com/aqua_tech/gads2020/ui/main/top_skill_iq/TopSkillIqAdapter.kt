package com.aqua_tech.gads2020.ui.main.top_skill_iq

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.api.top_skill_iq.TopSkillIq


class TopSkillIqAdapter(private val topSkillIqs: List<TopSkillIq>) :
    RecyclerView.Adapter<TopSkillIqAdapter.TopSkillIqViewHolder>() {
    inner class TopSkillIqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivTopSkillIq: ImageView = itemView.findViewById(R.id.iv_top_skill_iq)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvSubTitle: TextView = itemView.findViewById(R.id.tv_sub_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopSkillIqViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val topSkillIqView: View = inflater.inflate(R.layout.item_top_skill_iq, parent, false)
        return TopSkillIqViewHolder(topSkillIqView)
    }

    override fun onBindViewHolder(holder: TopSkillIqViewHolder, position: Int) {
        val topSkillIq = topSkillIqs[position]
        holder.tvTitle.text = topSkillIq.name
        holder.tvSubTitle.text = "${topSkillIq.score} skill IQ, Kenya."
    }

    override fun getItemCount() = topSkillIqs.size
}