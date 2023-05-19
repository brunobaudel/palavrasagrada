package com.mobsky.home.data.repository.mapper

import com.mobsky.home.data.local.database.model.BookEntity
import com.mobsky.home.data.local.database.model.BooksEntity
import com.mobsky.home.data.network.api.model.book.BooksResponse
import com.mobsky.home.data.network.api.model.verse_book.VerseBookResponse
import com.mobsky.home.data.repository.Books
import com.mobsky.home.domain.model.Book
import com.mobsky.home.domain.model.Verse

fun BooksResponse?.toBooks(): Books =
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

fun BookEntity?.toBook(): Book =
    this?.let { booksEntity ->
        Book(
            author = booksEntity.author,
            chapters = booksEntity.chapters,
            group = booksEntity.group,
            name = booksEntity.name,
            testament = booksEntity.testament
        )
    } ?: Book()

fun VerseBookResponse?.toVerse(testament: String): Verse =
    this?.let { verseBook ->
        Verse(
            book = verseBook.bookResponse?.name.orEmpty(),
            abrevPt = verseBook.bookResponse?.abbrev?.pt.orEmpty(),
            testament = testament,
            chapters = verseBook.chapter ?: 0,
            verseNumber = verseBook.number ?: 0,
            text = verseBook.text.orEmpty()
        )
    } ?: Verse()
    