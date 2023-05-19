package com.mobsky.home.di


import com.mobsky.home.domain.usecase.GetBooksUseCase
import org.koin.dsl.module

internal val homeUseCasesModules = module {

    single {
        GetBooksUseCase(aBibliaDigitalRepository = get())
    }

}
