package com.bambeach.cvstakehome.ui.home

import com.bambeach.cvstakehome.model.Image

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data object Error : HomeUiState
    data class Success(val images: List<Image>) : HomeUiState
}