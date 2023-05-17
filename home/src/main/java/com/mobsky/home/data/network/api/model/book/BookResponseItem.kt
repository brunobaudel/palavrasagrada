package com.mobsky.home.data.network.api.model.book


import com.google.gson.annotations.SerializedName

data class BookResponseItem(
    @SerializedName("abbrev")
    val abbrev: Abbrev? = Abbrev(),
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("chapters")
    val chapters: Int? = 0,
    @SerializedName("group")
    val group: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("testament")
    val testament: String? = ""
)