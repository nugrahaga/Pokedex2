package com.example.pokedex2.domain.usecase

import com.example.pokedex2.data.source.remote.Resource
import com.example.pokedex2.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonList {

    operator fun invoke(): Flow<Resource<List<Pokemon>>>
}