package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.ABibliaDigitalRepository
import com.mobsky.home.data.repository.Books

class GetUserUseCase(
    private val aBibliaDigitalRepository: ABibliaDigitalRepository
) : UseCase<Books, Unit>() {

    override suspend fun run(params: Unit): Books = let {
        aBibliaDigitalRepository.getBooks()
    }
}