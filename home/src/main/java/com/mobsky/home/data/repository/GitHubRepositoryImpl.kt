package com.mobsky.home.data.repository

import com.mobsky.home.data.local.ABibliaDigitalDatabase
import com.mobsky.home.data.network.ABibliaDigitalNetwork
import com.mobsky.home.data.repository.mapper.toBook
import com.mobsky.home.data.repository.mapper.toBooks
import com.mobsky.home.data.repository.mapper.toBooksEntity
import com.mobsky.home.data.repository.mapper.toVerse
import com.mobsky.home.domain.model.Book
import com.mobsky.home.domain.model.Verse
import com.mobsky.network.util.getSuccessResultWrapper
import com.mobsky.network.util.result

class ABibliaDigitalRepositoryImpl(
    private val aBibliaDigitalNetwork: ABibliaDigitalNetwork,
    private val aBibliaDigitalDatabase: ABibliaDigitalDatabase
) : ABibliaDigitalRepository {

    override suspend fun getBooks(): Books =
        result {

            var result = booksDataBase()

            if (result.isEmpty()) {
                result = booksOnLine()
                aBibliaDigitalDatabase.insertBooks(result.toBooksEntity())
            }

            result
        }

    override suspend fun getVerseRandom(): Verse = result {

        val book = booksRandomDataBase()

        book.getRandomChapter()

        verseBooksRandomOnLine(
            book.testament,
            "nvi",
            book.abrevPt
        )
    }


    private suspend fun booksOnLine(): Books =
        aBibliaDigitalNetwork.getBooks().getSuccessResultWrapper().toBooks()

    private suspend fun booksDataBase(): Books =
        aBibliaDigitalDatabase.getBooks().getSuccessResultWrapper().toBooks()

    private suspend fun booksRandomDataBase(): Book =
        aBibliaDigitalDatabase.getBookRandom().getSuccessResultWrapper().toBook()

    private suspend fun verseBooksRandomOnLine(
        testament: String = "",
        version: String,
        abbrev: String
    ): Verse =
        aBibliaDigitalNetwork
            .getVerseToBookRandom(version, abbrev)
            .getSuccessResultWrapper()
            .toVerse(testament)

}
