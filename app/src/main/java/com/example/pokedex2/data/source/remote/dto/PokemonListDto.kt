package com.example.pokedex2.data.source.remote.dto

data class PokemonListDto(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonDto>
)