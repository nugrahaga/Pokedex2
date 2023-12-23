package com.example.pokedex2.di

import com.example.pokedex2.data.repository.PokemonRepositoryImpl
import com.example.pokedex2.data.source.remote.PokemonApiService
import com.example.pokedex2.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonRepositoryModule {

    @Provides
    @Singleton
    fun providePokemonRepository(pokemonApiService: PokemonApiService): PokemonRepository =
        PokemonRepositoryImpl(pokemonApiService)
}