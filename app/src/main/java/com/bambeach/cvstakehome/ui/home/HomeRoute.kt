package com.bambeach.cvstakehome.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bambeach.cvstakehome.model.Image

@Composable
fun HomeRoute(
    onBackClick: () -> Unit,
    onImageClick: (Image) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        onImageClick = onImageClick,
        onBackClick = onBackClick,
        onQueryChange = viewModel::onQueryChange,
        modifier = modifier
    )
}