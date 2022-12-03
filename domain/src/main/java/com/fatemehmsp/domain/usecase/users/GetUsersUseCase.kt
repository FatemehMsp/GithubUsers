package com.fatemehmsp.domain.usecase.users

import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.domain.repository.UsersRepository
import com.fatemehmsp.domain.request.UserRequest
import com.fatemehmsp.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepository
): BaseUseCase<UserRequest,List<UserDomainModel>> {

    override suspend fun invoke(input: UserRequest): List<UserDomainModel> =
        repository.getUserList(input)
}