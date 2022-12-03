package com.fatemehmsp.data.repository

import com.fatemehmsp.data.datasource.remote.UsersDataSource
import com.fatemehmsp.data.entity.mapper.toDomain
import com.fatemehmsp.domain.repository.UsersRepository
import com.fatemehmsp.domain.request.UserRequest
import javax.inject.Inject

class UsersRepositoryImp @Inject constructor(
    private val usersDataSource : UsersDataSource
):UsersRepository{

    override suspend fun getUserList(userRequest: UserRequest) =
        usersDataSource.getUserList(userRequest).map { it.toDomain() }
}