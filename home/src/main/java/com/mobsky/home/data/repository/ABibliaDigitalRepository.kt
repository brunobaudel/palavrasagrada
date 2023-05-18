package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.Book

typealias Books =  List<Book>

interface ABibliaDigitalRepository {
    suspend fun getBooks(): Books
}