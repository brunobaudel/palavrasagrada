package com.mobsky.home.data.network.api.model.verse_book


import com.google.gson.annotations.SerializedName
import com.mobsky.home.data.network.api.model.commun.Abbrev

data class BookResponse(
    @SerializedName("abbrev")
    val abbrev: Abbrev? = Abbrev(),
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("group")
    val group: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("version")
    val version: String? = null
)