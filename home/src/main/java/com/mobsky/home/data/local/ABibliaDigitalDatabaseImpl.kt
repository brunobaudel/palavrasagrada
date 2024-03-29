package com.mobsky.home.data.local

import com.mobsky.home.data.local.database.ABibliaDigitalDAO
import com.mobsky.home.data.local.database.model.BookEntity
import com.mobsky.home.data.local.database.model.BooksEntity
import com.mobsky.network.util.ResultWrapper

class ABibliaDigitalDatabaseImpl(private val aBibliaDigitalDAO: ABibliaDigitalDAO) :
    ABibliaDigitalDatabase {

    override suspend fun getBooks(): ResultWrapper<BooksEntity> = try {
        val result = aBibliaDigitalDAO.getBooks()
        ResultWrapper.Success(result)
    } catch (exeption: Exception) {
        ResultWrapper.GenericError(0, exeption.message.orEmpty())
    }

    override suspend fun getBookRandom(): ResultWrapper<BookEntity> = try {
        val result = aBibliaDigitalDAO.getBookRandom()
        ResultWrapper.Success(result)
    } catch (exeption: Exception) {
        ResultWrapper.GenericError(0, exeption.message.orEmpty())
    }

    override suspend fun insertBooks(books: BooksEntity): List<Long> =
        aBibliaDigitalDAO.insertBook(books)

}