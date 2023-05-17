package com.mobsky.home.data.network


import com.mobsky.home.data.network.api.model.book.BookResponse
import com.mobsky.network.util.ResultWrapper

interface ABibliaDigitalNetwork {

    suspend fun getBooks(): ResultWrapper<BookResponse>

}