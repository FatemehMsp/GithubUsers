package com.fatemehmsp.data.network.api

import com.fatemehmsp.data.entity.remote.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUserList(
        @Query("since") since: Int,
        @Query("per_page") perPage: Int,
    ): List<UserResponse>
}