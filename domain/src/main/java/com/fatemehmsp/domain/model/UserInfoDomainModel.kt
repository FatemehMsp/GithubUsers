package com.fatemehmsp.domain.model

data class UserInfoDomainModel(
    val id: Long,
    val login: String,
    val name: String,
    val bio: String,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
    val followers: String,
    val following: String,
)
