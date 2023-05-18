package com.mobsky.home.data.network.api.model.book


import com.google.gson.annotations.SerializedName

data class BookResponseItem(
    @SerializedName("abbrev")
    val abbrev: Abbrev? = Abbrev(),
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("chapters")
    val chapters: Int? = null,
    @SerializedName("group")
    val group: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("testament")
    val testament: String? = null
)