package com.fatemehmsp.domain.model

import java.io.Serializable

data class UserDomainModel(
    val id: Long,
    val login: String,
    val avatarUrl: String,
    val url: String,
    val followersUrl: String,
    val followingUrl: String
): Serializable


