package com.example.pokedex2.data.source.remote.dto

import com.example.pokedex2.domain.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDto(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val pokemonName: String,
    @Json(name = "url")
    val pictureUrl: String
) {
    fun toPokemon() = Pokemon(
        id = id,
        name = pokemonName,
        url = pictureUrl
    )
}
