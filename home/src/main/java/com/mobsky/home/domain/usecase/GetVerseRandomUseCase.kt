package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.ABibliaDigitalRepository
import com.mobsky.home.data.repository.Books
import com.mobsky.home.domain.model.Verse

class GetVerseRandomUseCase(
    private val aBibliaDigitalRepository: ABibliaDigitalRepository
) : UseCase<Verse, Unit>() {

    override suspend fun run(params: Unit): Verse = let {
        aBibliaDigitalRepository.getVerseRandom()
    }
}