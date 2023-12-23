package com.example.pokedex2.presentation.ui.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.pokedex2.R
import com.example.pokedex2.domain.model.Pokemon
import com.example.pokedex2.presentation.viewmodel.PokemonListViewModel

@Composable
fun PokemonListScreen(
    pokemonListViewModel: PokemonListViewModel = hiltViewModel()
) {

    val state = pokemonListViewModel.state.value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(state.listOfPokemon.size) { index ->
            PokemonItem(
                pokemon = state.listOfPokemon[index],
                onItemClick = {
                    Log.i("PokemonListScreen", "Pokemon Item #$index Clicked")
                }
            )
        }
    }
}

@Composable
fun PokemonImage(
    urlString: String
) {
    val pokemonIndex = urlString.split("/")
    Image(
        painter = rememberImagePainter(
            data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonIndex[pokemonIndex.size - 2]}.png",
            builder = {
                placeholder(R.drawable.ic_launcher_foreground)
            }
        ),
        contentDescription = "Pokemon Image",
        modifier = Modifier
            .width(80.dp)
            .clip(RoundedCornerShape(4.dp))
    )
}

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    onItemClick: (Pokemon) -> Unit = {}
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onItemClick(pokemon)
                }
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokemonImage(urlString = pokemon.url)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = pokemon.name.uppercase(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview
fun Preview() {
    PokemonListScreen()
}