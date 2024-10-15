package com.bambeach.cvstakehome.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bambeach.cvstakehome.data.sampleImageList
import com.bambeach.cvstakehome.model.Image
import com.bambeach.cvstakehome.ui.components.ImageItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onBackClick: () -> Unit,
    onImageClick: (Image) -> Unit,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = { query ->
                        onQueryChange(query)
                        text = query
                    },
                    onSearch = { /*TODO*/ },
                    expanded = false,
                    onExpandedChange = { /*TODO*/ },
                    placeholder = { Text(text = "Search") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        if (text.isNotBlank()) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear",
                                modifier = Modifier.clickable {
                                    onQueryChange("")
                                    text = ""
                                }
                            )
                        }
                    }
                )
            },
            expanded = false,
            onExpandedChange = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {

        }
        when(uiState) {
            HomeUiState.Error -> ErrorScreen()
            HomeUiState.Loading -> LoadingScreen()
            is HomeUiState.Success -> SuccessScreen(
                images = uiState.images,
                onImageClick = onImageClick
            )
        }
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error Loading Images"
        )
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.testTag("Progress Indicator"))
    }
}

@Composable
fun SuccessScreen(
    images: List<Image>,
    onImageClick: (Image) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        items(images) { image ->
            ImageItem(
                image = image,
                onImageClick = onImageClick
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        uiState = HomeUiState.Success(sampleImageList),
        onImageClick = {},
        onBackClick = {},
        onQueryChange = {}
    )
}

@Preview
@Composable
fun SuccessScreenPreview() {
    SuccessScreen(
        images = sampleImageList,
        onImageClick = {}
    )
}