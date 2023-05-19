package com.mobsky.home.data.network


import com.mobsky.home.data.network.api.model.book.BooksResponse
import com.mobsky.home.data.network.api.model.verse_book.VerseBookResponse
import com.mobsky.network.util.ResultWrapper

interface ABibliaDigitalNetwork {

    suspend fun getBooks(): ResultWrapper<BooksResponse>

    suspend fun getVerseToBookRandom(
        version: String, abbrev: String
    ): ResultWrapper<VerseBookResponse>

}