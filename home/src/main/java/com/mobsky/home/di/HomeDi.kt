package com.mobsky.home.di


import com.mobsky.home.data.local.ABibliaDigitalDatabase
import com.mobsky.home.data.local.ABibliaDigitalDatabaseImpl
import com.mobsky.home.data.network.ABibliaDigitalNetwork
import com.mobsky.home.data.network.ABibliaDigitalNetworkImpl
import com.mobsky.home.data.repository.ABibliaDigitalRepository
import com.mobsky.home.data.repository.ABibliaDigitalRepositoryImpl
import org.koin.dsl.module

private val homeNetworkModules = module {
    single<ABibliaDigitalNetwork> { ABibliaDigitalNetworkImpl(get()) }
}

private val homeDataBaseModules = module {
    single<ABibliaDigitalDatabase> { ABibliaDigitalDatabaseImpl(get()) }
}

private val homeRepositoryModule = module {
    single<ABibliaDigitalRepository> { ABibliaDigitalRepositoryImpl(
        aBibliaDigitalNetwork = get(),
        aBibliaDigitalDatabase = get()
    ) }
}

val homeModules = listOf(
    homeNetworkModules,
    homeDataBaseModules,
    homeRepositoryModule,
    homeUseCasesModules,
    homeViewModelModules
)