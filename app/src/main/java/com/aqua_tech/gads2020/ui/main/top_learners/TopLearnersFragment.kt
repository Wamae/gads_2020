package com.aqua_tech.gads2020.ui.main.top_learners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.api.Status
import com.aqua_tech.gads2020.ui.main.MainActivity
import com.aqua_tech.gads2020.ui.main.TopLearner
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_top_learners.*

@AndroidEntryPoint
class TopLearnersFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private val viewModel: TopLearnersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_learners, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getTopLearners()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    private fun getTopLearners() {
        viewModel.getTopLearners().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        mainActivity.hideProgressBar()
                        resource.data?.let { topLearners -> loadTopLearners(topLearners) }
                    }
                    Status.ERROR -> {
                        mainActivity.hideProgressBar()
                        Toast.makeText(mainActivity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        mainActivity.showProgressBar()
                    }
                }
            }
        })
    }

    private fun loadTopLearners(topLearners: List<TopLearner>) {
        rv_top_learners.layoutManager = LinearLayoutManager(activity)
        rv_top_learners.adapter = TopLearnersAdapter(topLearners)
    }
}