package com.example.pokedex2.data.source.remote

import com.example.pokedex2.data.source.remote.dto.PokemonListDto
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemonList(): PokemonListDto

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

}