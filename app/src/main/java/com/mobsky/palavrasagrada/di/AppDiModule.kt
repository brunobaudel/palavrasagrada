package com.mobsky.palavrasagrada.di




import com.mobsky.network.StartNetworkParameters
import com.mobsky.network.startNetwork
import org.koin.core.module.Module
import org.koin.dsl.module

val startNetworkParameters = StartNetworkParameters(
    baseUrl = "BuildConfig.BASE_URL",
    isDebug = false
)

val appDiModule = module {

//    single {
//        get<Retrofit> {
//            parametersOf(startNetworkParameters)
//        }.create(GitHubApi::class.java)
//    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    )

