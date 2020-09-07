package com.aqua_tech.gads2020.ui.main

import com.aqua_tech.gads2020.R

enum class Model private constructor(val titleResId: Int, val layoutResId: Int) {
    LEARNING(R.string.learning_leaders, R.layout.fragment_learning_leaders),
    IQ(R.string.skill_iq_leaders, R.layout.fragment_skill_iq_learners)
}