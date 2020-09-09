package com.aqua_tech.gads2020.api

import com.aqua_tech.gads2020.api.top_learner.TopLearner
import com.aqua_tech.gads2020.api.top_skill_iq.TopSkillIq
import javax.inject.Inject

class LeadersRepository  @Inject constructor(private val apiGADSAPIService: GADSAPIService){
    suspend fun getTopLearners(): List<TopLearner> {
        return apiGADSAPIService.hours()
    }

    suspend fun getTopSkillIq(): List<TopSkillIq> {
        return apiGADSAPIService.skilliq()
    }
}