package com.example.pokedex2.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class PokemonListScreen {
}

@Composable
fun PokemonImage() {
    Image(
        painter = rememberImagePainter(
            data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            builder = {}
        ),
        contentDescription = "Pokemon Image",
        modifier = Modifier
            .width(88.dp)
            .clip(RoundedCornerShape(4.dp))
    )
}

@Composable
fun PokemonItem() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    print("Pokemon Item Clicked")
                }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokemonImage()
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Nama Pokemon")
        }
    }
}

@Composable
@Preview
fun Preview() {
    PokemonItem()
}