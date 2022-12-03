package com.fatemehmsp.data.datasource.remote

import com.fatemehmsp.data.network.api.ApiService
import com.fatemehmsp.domain.request.UserRequest
import javax.inject.Inject

class UsersDataSourceImp @Inject constructor(
    private val apiService: ApiService
): UsersDataSource {
    override suspend fun getUserList(userRequest: UserRequest) =
        apiService.getUserList(userRequest.since,userRequest.perPage)
}