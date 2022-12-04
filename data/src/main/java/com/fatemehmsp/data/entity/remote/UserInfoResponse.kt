package com.fatemehmsp.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInfoResponse(
    val id: Long,
    val login: String,
    val name: String?,
    val bio: String?,
    @Json(name = "avatar_url")
    val avatarUrl: String,
    val url: String,
    @Json(name = "html_url")
    val htmlUrl: String,
    val followers: String,
    val following: String,
)
