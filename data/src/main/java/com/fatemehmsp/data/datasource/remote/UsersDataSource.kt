package com.fatemehmsp.data.datasource.remote

import com.fatemehmsp.data.entity.remote.UserResponse
import com.fatemehmsp.domain.request.UserRequest

interface UsersDataSource {

    suspend fun getUserList(userRequest: UserRequest): List<UserResponse>
}