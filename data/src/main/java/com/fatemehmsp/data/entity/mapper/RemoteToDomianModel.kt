package com.fatemehmsp.data.entity.mapper

import com.fatemehmsp.data.entity.remote.UserInfoResponse
import com.fatemehmsp.data.entity.remote.UserResponse
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.domain.model.UserInfoDomainModel

fun UserResponse.toDomain() = UserDomainModel(
    id = this.id,
    login = this.login,
    avatarUrl = this.avatarUrl,
    url = this.url,
    htmlUrl = this.htmlUrl
)

fun UserInfoResponse.toDomain() = UserInfoDomainModel(
    id = this.id,
    login = this.login,
    avatarUrl = this.avatarUrl,
    name = this.name?:"",
    bio = this.bio?:"",
    url = this.url,
    htmlUrl = this.htmlUrl,
    followers = this.followers,
    following = this.following
)