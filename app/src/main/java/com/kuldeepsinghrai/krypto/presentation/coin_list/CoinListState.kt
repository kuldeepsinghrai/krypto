package com.kuldeepsinghrai.krypto.presentation.coin_list

import com.kuldeepsinghrai.krypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
