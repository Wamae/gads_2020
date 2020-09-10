package com.aqua_tech.gads2020.api

import com.aqua_tech.gads2020.api.top_learner.TopLearner
import com.aqua_tech.gads2020.api.top_skill_iq.TopSkillIq
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ProjectRepository @Inject constructor(private val apiService: GoogleFormAPIService) {
    suspend fun submitProject(
        firstName: String,
        lastName: String,
        email: String,
        projectLink: String
    ): Response<Unit> {
        return apiService.merchantRest(firstName, lastName, email, projectLink)
    }
}