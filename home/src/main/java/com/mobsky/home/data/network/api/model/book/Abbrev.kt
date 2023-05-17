package com.mobsky.home.data.network.api.model.book

import com.google.gson.annotations.SerializedName

data class Abbrev(
    @SerializedName("en")
    val en: String? = "",
    @SerializedName("pt")
    val pt: String? = ""
)