package com.example.pokedex2.data.repository

import com.example.pokedex2.data.source.remote.PokemonApiService
import com.example.pokedex2.data.source.remote.Resource
import com.example.pokedex2.domain.model.Pokemon
import com.example.pokedex2.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    private val pokemonApiService: PokemonApiService
) : PokemonRepository {
    override fun getPokemonList(): Flow<Resource<List<Pokemon>>> = flow {
        emit(Resource.Loading())
        try {
            val response = pokemonApiService.getPokemonList()
            val pokemonList = response.results.map { it.toPokemon() }
            emit(Resource.Success(pokemonList))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}