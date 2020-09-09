package com.aqua_tech.gads2020.api

import com.aqua_tech.gads2020.api.top_learner.TopLearner
import com.aqua_tech.gads2020.api.top_skill_iq.TopSkillIq
import retrofit2.http.GET


interface GADSAPIService {

    @GET("hours")
    suspend fun hours(): List<TopLearner>

    @GET("skilliq")
    suspend fun skilliq(): List<TopSkillIq>
}