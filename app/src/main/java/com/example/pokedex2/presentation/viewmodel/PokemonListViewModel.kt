package com.example.pokedex2.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.data.source.remote.Resource
import com.example.pokedex2.domain.model.Pokemon
import com.example.pokedex2.domain.usecase.GetPokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonList: GetPokemonList
) : ViewModel() {

    private val _state = mutableStateOf(UiState())
    val state: State<UiState> = _state

    init {
        getPokemons()
    }

    private fun getPokemons() {
        viewModelScope.launch {
            getPokemonList().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            listOfPokemon = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            listOfPokemon = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            listOfPokemon = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                }
            }.launchIn(this)
        }
    }
}

data class UiState(
    val listOfPokemon: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false
)