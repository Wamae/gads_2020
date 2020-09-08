package com.aqua_tech.gads2020.ui.main.top_learners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.ui.main.TopLearner
import kotlinx.android.synthetic.main.fragment_top_learners.*

class TopLearnersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_learners, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val topLearners = mutableListOf<TopLearner>()
        topLearners.add(TopLearner("John Doe", 20, "Nigeria", "URL"))
        topLearners.add(TopLearner("Jane Doe", 15, "Ghana", "URL"))

        rv_top_learners.layoutManager = LinearLayoutManager(activity)
        rv_top_learners.adapter = TopLearnersAdapter(topLearners)
    }
}