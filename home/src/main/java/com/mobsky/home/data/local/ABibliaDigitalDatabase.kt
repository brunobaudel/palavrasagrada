package com.mobsky.home.data.local

import com.mobsky.home.data.local.database.model.BooksEntity
import com.mobsky.network.util.ResultWrapper

interface ABibliaDigitalDatabase {

    suspend fun getBooks(): ResultWrapper<BooksEntity>
    suspend fun insertBooks(books: BooksEntity): List<Long>

}