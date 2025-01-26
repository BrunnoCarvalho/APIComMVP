package com.brunocarvalho.apicommvp.model

data class Postagem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)