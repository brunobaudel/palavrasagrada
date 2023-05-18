package com.mobsky.home.data.repository.mapper

import com.mobsky.home.data.local.database.model.BookEntity
import com.mobsky.home.data.local.database.model.BooksEntity
import com.mobsky.home.data.network.api.model.book.BookResponse
import com.mobsky.home.data.repository.Books
import com.mobsky.home.domain.model.Book

fun BookResponse?.toBooks(): Books =
    this?.map { bookResponse ->
        Book(
            author = bookResponse.author.orEmpty(),
            chapters = bookResponse.chapters ?: 0,
            group = bookResponse.group.orEmpty(),
            name = bookResponse.name.orEmpty(),
            testament = bookResponse.testament.orEmpty(),
            abrevEn = bookResponse.abbrev?.en.orEmpty(),
            abrevPt = bookResponse.abbrev?.pt.orEmpty()
        )
    } ?: listOf()


fun BooksEntity?.toBooks(): Books =
    this?.map { booksEntity ->
        Book(
            author = booksEntity.author,
            chapters = booksEntity.chapters,
            group = booksEntity.group,
            name = booksEntity.name,
            testament = booksEntity.testament
        )
    } ?: listOf()


fun Books?.toBooksEntity(): BooksEntity =
    this?.map { book ->
        BookEntity(
            author = book.author,
            chapters = book.chapters,
            group = book.group,
            name = book.name,
            testament = book.testament,
            abrevEn = book.abrevEn,
            abrevPt = book.abrevPt
        )
    } ?: listOf()
