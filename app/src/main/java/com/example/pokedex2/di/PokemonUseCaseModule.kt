package com.example.pokedex2.di

import com.example.pokedex2.data.usecase.GetPokemonListImpl
import com.example.pokedex2.domain.repository.PokemonRepository
import com.example.pokedex2.domain.usecase.GetPokemonList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonUseCaseModule {

    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(
        pokemonRepository: PokemonRepository
    ): GetPokemonList = GetPokemonListImpl(pokemonRepository)
}