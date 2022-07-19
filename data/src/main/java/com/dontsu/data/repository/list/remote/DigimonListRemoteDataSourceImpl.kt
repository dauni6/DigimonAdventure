package com.dontsu.data.repository.list.remote

import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonListRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi
): DigimonListRemoteDataSource {

    override fun getDigimonList(pageSize: Int): Flow<DigimonList> {
        // todo : local 먼저 확인하는 코드 작성해줄 것
        val response = api.getDigimonList(pageSize = pageSize)
        if (response.isSuccessful) {
            val digimons =

        } else {

        }
        return api.getDigimonList(pageSize = pageSize)
    }

}
