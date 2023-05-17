package com.mobsky.home.data.repository

import com.mobsky.home.data.network.api.model.book.BookResponse


interface ABibliaDigitalRepository {
    suspend fun getBooks(): BookResponse
}