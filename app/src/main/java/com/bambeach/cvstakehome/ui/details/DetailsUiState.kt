package com.bambeach.cvstakehome.ui.details

import com.bambeach.cvstakehome.model.Image

sealed interface DetailsUiState {
    data class Success(val image: Image) : DetailsUiState
    data object Error : DetailsUiState
    data object Loading : DetailsUiState
}