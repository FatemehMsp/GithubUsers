package com.fatemehmsp.domain.repository

import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.domain.request.UserRequest

interface UsersRepository {

    suspend fun getUserList(userRequest: UserRequest):List<UserDomainModel>
}