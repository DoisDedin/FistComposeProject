package com.example.fistprojectcompose.data.remote.dto

import com.example.fistprojectcompose.domain.model.a.CoinDetail

data class CoinDetailDto(
    val description: String,
    val developmentStatus: String,
    val firstDataAt: String,
    val hardwareWallet: Boolean,
    val hashAlgorithm: String,
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val lastDataAt: String,
    val links: Links,
    val linksExtended: List<LinksExtended>,
    val message: String,
    val name: String,
    val openSource: Boolean,
    val orgStructure: String,
    val proofType: String,
    val rank: Int,
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail{
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}

