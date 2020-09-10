package com.aqua_tech.gads2020.ui.main.top_skill_iq

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
import com.aqua_tech.gads2020.api.top_skill_iq.TopSkillIq
import com.aqua_tech.gads2020.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_top_skill_iqs.*

@AndroidEntryPoint
class TopSkillIqsFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private val viewModel: TopSkillIqsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_skill_iqs, container, false)
    }

    override fun onResume() {
        super.onResume()
        getTopSkillIqs()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    private fun getTopSkillIqs() {
        viewModel.getTopSkillIq().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        mainActivity.hideProgressBar()
                        resource.data?.let { topSkillIqs -> loadTopSkillIqs(topSkillIqs) }
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

    private fun loadTopSkillIqs(topSkillIq: List<TopSkillIq>) {
        rv_top_skill_iqs.layoutManager = LinearLayoutManager(activity)
        rv_top_skill_iqs.adapter = TopSkillIqAdapter(topSkillIq)
    }
}