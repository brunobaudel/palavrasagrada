package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.Book
import com.mobsky.home.domain.model.Verse

typealias Books =  List<Book>

interface ABibliaDigitalRepository {
    suspend fun getBooks(): Books
    suspend fun getVerseRandom(): Verse
}