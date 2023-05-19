package com.mobsky.home.domain.model

data class Book(
    val author: String = "",
    val chapters: Int = 0,
    val group: String = "",
    val name: String = "",
    val testament: String = "",
    val abrevEn: String = "",
    val abrevPt: String = ""
){
    fun getRandomChapter():Int = let{
        1
    }
}
