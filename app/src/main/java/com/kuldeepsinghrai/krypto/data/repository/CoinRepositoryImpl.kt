package com.kuldeepsinghrai.krypto.data.repository

import com.kuldeepsinghrai.krypto.data.remote.CoinPaprikaApi
import com.kuldeepsinghrai.krypto.data.remote.dto.CoinDetailDto
import com.kuldeepsinghrai.krypto.data.remote.dto.CoinDto
import com.kuldeepsinghrai.krypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}