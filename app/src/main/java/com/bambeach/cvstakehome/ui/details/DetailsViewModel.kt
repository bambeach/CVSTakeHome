package com.bambeach.cvstakehome.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val imageUrl = savedStateHandle.getStateFlow(IMAGE_URL_STATE_KEY, "")

    val _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState

}

private const val IMAGE_URL_STATE_KEY = "imageUrl"