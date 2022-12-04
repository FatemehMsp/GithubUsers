package com.fatemehmsp.data.network.api

import com.fatemehmsp.data.entity.remote.UserInfoResponse
import com.fatemehmsp.data.entity.remote.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("users")
    suspend fun getUserList(
        @Query("since") since: Int,
        @Query("per_page") perPage: Int,
    ): List<UserResponse>

    @GET
    suspend fun getUserInfo(
        @Url url: String
    ): UserInfoResponse
}