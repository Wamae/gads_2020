package com.aqua_tech.gads2020.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.aqua_tech.gads2020.R
import com.aqua_tech.gads2020.ui.main.top_learners.TopLearnersFragment


class TabAdapter(private val mContext: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TopLearnersFragment()
            }
            1 -> {
                TopLearnersFragment()
            }
            else -> TopLearnersFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> {
                mContext.getString(R.string.learning_leaders)
            }
            1 -> {
                mContext.getString(R.string.skill_iq_leaders)
            }
            else -> mContext.getString(R.string.learning_leaders)
        }
    }
}