package com.fatemehmsp.buildsrc

class Dependency(
    private val id: String,
    private val version: String
) {
    override fun toString(): String = "${id.trim()}:${getLatestVersionIfVersionIsEmpty().trim()}"

    private fun getLatestVersionIfVersionIsEmpty(): String = if (version.isNotBlank()) {
        version
    } else {
        "+"
    }

    operator fun invoke(): String = this.toString()
}