package org.example.drangonball.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val homeViewModel : HomeViewModel = koinViewModel()
    val example by homeViewModel.example.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Text(text = example)
    }

}