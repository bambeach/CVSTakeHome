package com.bambeach.cvstakehome.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bambeach.cvstakehome.model.Image

@Composable
fun DetailsRoute(
    image: Image,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailsScreen(
        image = image,
        uiState = uiState,
        onBackClick = onBackClick
    )
}