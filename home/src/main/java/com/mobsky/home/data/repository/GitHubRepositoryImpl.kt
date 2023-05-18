package com.mobsky.home.data.repository

import com.mobsky.home.data.local.ABibliaDigitalDatabase
import com.mobsky.home.data.network.ABibliaDigitalNetwork
import com.mobsky.home.data.repository.mapper.toBooks
import com.mobsky.home.data.repository.mapper.toBooksEntity
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

    private suspend fun booksOnLine(): Books =
        aBibliaDigitalNetwork.getBooks().getSuccessResultWrapper().toBooks()

    private suspend fun booksDataBase(): Books =
        aBibliaDigitalDatabase.getBooks().getSuccessResultWrapper().toBooks()

}
