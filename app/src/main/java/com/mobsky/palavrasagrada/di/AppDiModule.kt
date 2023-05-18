package com.mobsky.palavrasagrada.di

import com.mobsky.home.data.network.api.ABibliaDigitalApi
import com.mobsky.home.di.homeModules
import com.mobsky.network.StartNetworkParameters
import com.mobsky.network.startNetwork
import com.mobsky.palavrasagrada.BuildConfig
import com.mobsky.palavrasagrada.database.PalavraSagradaDatabase
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

val startNetworkParameters = StartNetworkParameters(
    baseUrl = BuildConfig.BASE_URL,
    isDebug = BuildConfig.DEBUG
)

val appDiModule = module {

    single {
        get<Retrofit> {
            parametersOf(startNetworkParameters)
        }.create(ABibliaDigitalApi::class.java)
    }

    single {
        PalavraSagradaDatabase.getDatabase(context = get()).aBibliaDigitalDAO()
    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    )
        .plus(homeModules)

