package com.bambeach.cvstakehome.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bambeach.cvstakehome.data.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val imageRepository: ImageRepository,
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    val query = stateHandle.getStateFlow(QUERY_STATE_KEY, "")
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        onQueryChange(query = query.value)
    }

    fun onQueryChange(query: String) {
        _uiState.value = HomeUiState.Loading

        viewModelScope.launch(
            Dispatchers.IO
        ) {
            val images = imageRepository.getImages(tags = query)
            if (images.isNotEmpty()) {
                _uiState.value = HomeUiState.Success(images)
            } else {
                _uiState.value = HomeUiState.Error
            }
        }
    }
}

private const val QUERY_STATE_KEY = "query"