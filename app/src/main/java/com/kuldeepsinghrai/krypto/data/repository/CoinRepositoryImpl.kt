package com.kuldeepsinghrai.krypto.data.repository

import com.kuldeepsinghrai.krypto.common.Constants
import com.kuldeepsinghrai.krypto.data.remote.CoinPaprikaApi
import com.kuldeepsinghrai.krypto.data.remote.dto.CoinDetailDto
import com.kuldeepsinghrai.krypto.data.remote.dto.CoinDto
import com.kuldeepsinghrai.krypto.domain.repository.CoinRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

private val json = Json {
    ignoreUnknownKeys = true
}

class CoinRepositoryImpl @Inject constructor(
    private val client: HttpClient
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        val response: HttpResponse = client.get(Constants.BASE_URL + "/v1/coins")

        val coins = json.decodeFromString<List<CoinDto>>(response.bodyAsText())
        return coins
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        val response: HttpResponse = client.get(Constants.BASE_URL + "/v1/coins/$coinId")
        val coin = json.decodeFromString<CoinDetailDto>(response.bodyAsText())
        return coin
    }
}