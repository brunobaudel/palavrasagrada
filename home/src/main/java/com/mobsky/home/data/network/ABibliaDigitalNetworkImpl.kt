package com.mobsky.home.data.network

import com.mobsky.home.data.network.api.ABibliaDigitalApi
import com.mobsky.home.data.network.api.model.book.BookResponse
import com.mobsky.network.util.ResultWrapper
import com.mobsky.network.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ABibliaDigitalNetworkImpl(
    private val gitHubApi: ABibliaDigitalApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ABibliaDigitalNetwork {

    override suspend fun getBooks(): ResultWrapper<BookResponse> =
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

}
