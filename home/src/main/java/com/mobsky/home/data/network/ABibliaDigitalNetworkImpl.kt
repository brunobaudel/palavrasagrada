package com.mobsky.home.data.network

import com.mobsky.home.data.network.api.ABibliaDigitalApi
import com.mobsky.home.data.network.api.model.book.BooksResponse
import com.mobsky.home.data.network.api.model.verse_book.VerseBookResponse
import com.mobsky.network.util.ResultWrapper
import com.mobsky.network.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Path

class ABibliaDigitalNetworkImpl(
    private val gitHubApi: ABibliaDigitalApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ABibliaDigitalNetwork {

    override suspend fun getBooks(): ResultWrapper<BooksResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getBooks()
            },
            transformError = {
//                Gson().fromJson(it, GitErrorModelResponse::class.java).message
                ""
            }
        )

    override suspend fun getVerseToBookRandom(
        version: String,
        abbrev: String
    ): ResultWrapper<VerseBookResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getVerseToChapterRandom(version, abbrev)
            },
            transformError = {
//                Gson().fromJson(it, GitErrorModelResponse::class.java).message
                ""
            }
        )

}
