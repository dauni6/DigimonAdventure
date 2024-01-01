package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Digimon

interface GetDigimonDetailUseCase {
    suspend operator fun invoke(id: Int): Digimon
}
