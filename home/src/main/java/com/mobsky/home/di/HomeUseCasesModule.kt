package com.mobsky.home.di


import com.mobsky.home.domain.usecase.GetBooksUseCase
import com.mobsky.home.domain.usecase.GetVerseRandomUseCase
import org.koin.dsl.module

internal val homeUseCasesModules = module {

    single {
        GetBooksUseCase(aBibliaDigitalRepository = get())
    }

    single {
        GetVerseRandomUseCase(aBibliaDigitalRepository = get())
    }

}
