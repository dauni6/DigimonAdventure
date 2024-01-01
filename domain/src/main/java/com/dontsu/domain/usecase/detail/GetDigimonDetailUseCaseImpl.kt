package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import javax.inject.Inject

class GetDigimonDetailUseCaseImpl @Inject constructor(
    private val repository: DigimonDetailRepository
): GetDigimonDetailUseCase {
    override suspend fun invoke(id: Int): Digimon = repository.getDigimon(id = id)
}
