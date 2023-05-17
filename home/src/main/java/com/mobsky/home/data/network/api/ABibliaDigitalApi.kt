package com.mobsky.home.data.network.api

import com.mobsky.home.data.network.api.model.book.BookResponse
import retrofit2.http.GET

interface ABibliaDigitalApi {

    /**
     * Lista os livros da biblia
     */
    @GET("books")
    suspend fun getBooks(): BookResponse


}