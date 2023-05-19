package com.mobsky.home.data.network.api

import com.mobsky.home.data.network.api.model.book.BooksResponse
import com.mobsky.home.data.network.api.model.verse_book.VerseBookResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ABibliaDigitalApi {

    /**
     * Lista os livros da biblia
     */
    @GET("books")
    suspend fun getBooks(): BooksResponse

    /**
     * Recupera um versiculo aleatorio do capitulo
     */
    @GET("verses/{version}/{abbrev}/random")
    suspend fun getVerseToChapterRandom(
        @Path("version") version: String = "nvi",
        @Path("abbrev") abbrev: String
    ): VerseBookResponse

}