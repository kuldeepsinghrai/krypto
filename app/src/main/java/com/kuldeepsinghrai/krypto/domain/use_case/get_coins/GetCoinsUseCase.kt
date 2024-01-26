package com.kuldeepsinghrai.krypto.domain.use_case.get_coins

import com.kuldeepsinghrai.krypto.common.Resource
import com.kuldeepsinghrai.krypto.data.remote.dto.toCoin
import com.kuldeepsinghrai.krypto.data.repository.CoinRepositoryImpl
import com.kuldeepsinghrai.krypto.domain.model.Coin
import com.kuldeepsinghrai.krypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}