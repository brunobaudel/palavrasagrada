package com.mobsky.home.di


import com.mobsky.home.domain.usecase.GetUserUseCase
import org.koin.dsl.module

internal val homeUseCasesModules = module {

    single {
        GetUserUseCase(aBibliaDigitalRepository = get())
    }

}
