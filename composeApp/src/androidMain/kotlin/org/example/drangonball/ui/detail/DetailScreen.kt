package org.example.drangonball.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.example.drangonball.domain.model.CharacterDetailModel
import org.example.drangonball.resource.orange
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.example.drangonball.R
import org.example.drangonball.domain.model.TransformationModel

@Composable
fun DetailScreen(id: Int, navigateBack: () -> Unit) {
    val detailViewModel: DetailViewModel = koinViewModel(parameters = { parametersOf(id) })
    val detail by detailViewModel.character.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        detail?.let { character ->
            ItemDetail(character = character, navigateBack = navigateBack)
        } ?: run {
            CircularProgressIndicator(color = orange)
        }
    }
}

@Composable
fun ItemDetail(character: CharacterDetailModel, navigateBack: () -> Unit) {
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
        Box(contentAlignment = Alignment.TopCenter) {
            Card(
                Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 64.dp, top = 150.dp)
                    .fillMaxSize()
            ) {
                Column() {
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text = character.characterModel.name,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Label(character.characterModel.race)
                        Spacer(modifier = Modifier.width(32.dp))
                        Label(character.characterModel.gender)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.height(75.dp)) {
                        IconInformation(
                            Modifier.weight(1f),
                            painterResource(R.drawable.one),
                            character.characterModel.ki
                        )
                        VerticalDivider(thickness = 2.dp)
                        IconInformation(
                            Modifier.weight(1f),
                            painterResource(R.drawable.body),
                            character.originPlanet.name
                        )
                    }
                    TransformationList(Modifier.fillMaxSize(), character.transformations)
                }
            }
            AsyncImage(
                model = character.characterModel.image,
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(vertical = 24.dp)
            )

            Row(Modifier.fillMaxWidth()) {
                Icon(
                    painterResource(id = R.drawable.outline_arrow_back_24),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable { navigateBack() }
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }

    }
}

@Composable
fun TransformationList(modifier: Modifier, transformations: List<TransformationModel>) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        if (transformations.isEmpty()) {
            Text(text = "No hay transformaciones")
        } else {
            val pagerState = rememberPagerState(pageCount = { transformations.size })

            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fixed(pageSize = 150.dp),
                pageSpacing = 4.dp
            ) { pos ->
                TransformationSticker(transformations[pos])
            }
        }
    }
}

@Composable
fun TransformationSticker(transformation: TransformationModel) {
    Card(
        modifier = Modifier.padding(horizontal = 6.dp, vertical = 24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        onClick = {},
        border = BorderStroke(1.dp, Color.Gray.copy(0.4f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier.weight(0.8f),
                model = transformation.image,
                contentDescription = null
            )
            Text(
                text = transformation.name,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Label(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .border(2.dp, orange, RoundedCornerShape(50))
            .padding(horizontal = 16.dp, vertical = 2.dp)

    )
}

@Composable
fun IconInformation(modifier: Modifier, painter: Painter, text: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier.size(48.dp)
        )
        Text(text = text)
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