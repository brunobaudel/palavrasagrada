package com.mobsky.home.data.repository


import com.mobsky.home.data.network.ABibliaDigitalNetwork
import com.mobsky.home.data.network.api.model.book.BookResponse

class ABibliaDigitalRepositoryImpl(
    private val gitHubNetwork: ABibliaDigitalNetwork
) : ABibliaDigitalRepository {

    //    override suspend fun getUsers(): Users {
//        return result {
//
//
//                gitHubNetwork
//                    .getUsers()
//                    .getSuccessResultWrapper()
//                    .toGitUsers()
//        }
//    }
    override suspend fun getBooks(): BookResponse {
        TODO("Not yet implemented")
    }

}