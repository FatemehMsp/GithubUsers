package com.fatemehmsp.domain.usecase.userinfo

import com.fatemehmsp.domain.model.UserInfoDomainModel
import com.fatemehmsp.domain.repository.UsersRepository
import com.fatemehmsp.domain.request.UserInfoRequest
import com.fatemehmsp.domain.usecase.BaseUseCase
import javax.inject.Inject

class UserInfoUseCase @Inject constructor(
    private val repository: UsersRepository
): BaseUseCase<UserInfoRequest, UserInfoDomainModel> {

    override suspend fun invoke(input: UserInfoRequest): UserInfoDomainModel =
        repository.getUserInfo(input)
}