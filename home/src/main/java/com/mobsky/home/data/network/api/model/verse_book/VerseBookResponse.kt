package com.mobsky.home.data.network.api.model.verse_book


import com.google.gson.annotations.SerializedName

data class VerseBookResponse(
    @SerializedName("book")
    val bookResponse: BookResponse? = null,
    @SerializedName("chapter")
    val chapter: Int? = null,
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("text")
    val text: String? = null
)