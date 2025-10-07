package org.example.drangonball.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.example.drangonball.domain.model.CharacterModel
import org.example.drangonball.resource.orange
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.example.drangonball.R
import org.example.drangonball.R.drawable
import org.example.drangonball.resource.BackgroundPrimary

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = koinViewModel()
    val characters by homeViewModel.characters.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier = Modifier.padding(top = 16.dp),text= "Goku Edition", fontWeight = FontWeight.Bold, fontSize = 32.sp, color = Color.White)
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp)) {
            items(characters) { character ->
                CharacterItem(character){
                    //navegar
                }
            }
        }

    }

}

@Composable
fun CharacterItem(character: CharacterModel, onItemClick: (CharacterModel) -> Unit) {
    Box(
        Modifier
            .padding(16.dp)
            .height(250.dp)
            .clickable{ onItemClick(character)},
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1f))
            Card(Modifier.fillMaxWidth(), border = BorderStroke(4.dp,orange)) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(character.name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Text(character.race, fontSize = 20.sp, fontStyle = FontStyle.Italic)
                }
            }

        }
        DragonBallShape()
        AsyncImage(
            model = character.image,
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )
    }
}

@Composable
fun DragonBallShape() {
    Box(
        modifier = Modifier
            .size(180.dp)
            .clip(CircleShape)
            .background(orange)
            .border(
                BorderStroke(
                    6.dp,
                    Brush.horizontalGradient(listOf(Color.White.copy(alpha = 0.6f), orange, orange))
                ), CircleShape
            ), contentAlignment = Alignment.Center
    ) {
        Row {
            Column {
                DragonBallStar()
                DragonBallStar()
            }
            Column {
                DragonBallStar()
                DragonBallStar()
            }
        }

    }
}

@Composable
fun DragonBallStar() {
    Icon(
        modifier = Modifier
            .padding(10.dp)
            .size(24.dp),
        painter = painterResource(id = R.drawable.ic_star),
        contentDescription = null,
        tint = Color.Red
    )
}