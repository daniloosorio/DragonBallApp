package org.example.drangonball.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.example.drangonball.domain.model.CharacterDetailModel
import org.example.drangonball.resource.orange
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(id: Int) {
    val detailViewModel: DetailViewModel = koinViewModel(parameters = { parametersOf(id) })
    val detail by detailViewModel.character.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        detail?.let { character ->
            ItemDetail(character = character)
        } ?: run {
            CircularProgressIndicator(color = orange)
        }
    }
}

@Composable
fun ItemDetail(character: CharacterDetailModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color.Black, orange),
                    startY = 0f,
                    endY = 450f
                )
            )
    ) {
        Card(Modifier.padding(horizontal = 16.dp, vertical = 56.dp)) {

        }
    }
}

/*@Composable
fun ItemDetail(character: CharacterDetailModel) {
    Column(Modifier.fillMaxSize()
        .background(Color.Black.copy(alpha = 0.6f))) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .width(250.dp)
                .clip(RoundedCornerShape(bottomStartPercent = 15, bottomEndPercent = 15))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(model = character.characterModel.image, contentDescription = null)
        }

    }
}*/