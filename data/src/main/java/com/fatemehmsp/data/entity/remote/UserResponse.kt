package com.fatemehmsp.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    val id: Long,
    val login: String,
    @Json(name = "avatar_url")
    val avatarUrl: String,
    val url: String,
    @Json(name = "html_url")
    val htmlUrl: String,
)
