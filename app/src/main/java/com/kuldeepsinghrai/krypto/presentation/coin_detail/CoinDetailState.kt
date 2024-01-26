package com.kuldeepsinghrai.krypto.presentation.coin_detail

import com.kuldeepsinghrai.krypto.domain.model.Coin
import com.kuldeepsinghrai.krypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
