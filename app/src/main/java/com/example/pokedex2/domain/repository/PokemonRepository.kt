package com.example.pokedex2.domain.repository

import com.example.pokedex2.data.source.remote.Resource
import com.example.pokedex2.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(): Flow<Resource<List<Pokemon>>>
}