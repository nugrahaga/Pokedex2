package com.example.pokedex2.data.usecase

import com.example.pokedex2.data.source.remote.Resource
import com.example.pokedex2.domain.model.Pokemon
import com.example.pokedex2.domain.repository.PokemonRepository
import com.example.pokedex2.domain.usecase.GetPokemonList
import kotlinx.coroutines.flow.Flow

class GetPokemonListImpl(
    private val pokemonRepository: PokemonRepository
): GetPokemonList {
    override fun invoke(): Flow<Resource<List<Pokemon>>> =
        pokemonRepository.getPokemonList()
}