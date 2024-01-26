package com.kuldeepsinghrai.krypto.domain.repository

import com.kuldeepsinghrai.krypto.data.remote.dto.CoinDetailDto
import com.kuldeepsinghrai.krypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}