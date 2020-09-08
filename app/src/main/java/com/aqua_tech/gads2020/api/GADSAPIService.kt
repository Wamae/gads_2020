package com.aqua_tech.gads2020.api

import com.aqua_tech.gads2020.ui.main.TopLearner
import retrofit2.http.GET


interface GADSAPIService {

    @GET("hours")
    suspend fun hours(): List<TopLearner>

//    @GET("skilliq")
//    fun hours(): LiveData<ApiResponse<List<TopLearner>>>

}