package com.fatemehmsp.data.entity.mapper

import com.fatemehmsp.data.entity.remote.UserResponse
import com.fatemehmsp.domain.model.UserDomainModel

fun UserResponse.toDomain() = UserDomainModel(
    id = this.id,
    login = this.login,
    avatarUrl = this.avatarUrl,
    url = this.url,
    followersUrl = this.followersUrl,
    followingUrl = this.followingUrl,
)