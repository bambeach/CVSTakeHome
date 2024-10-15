package com.bambeach.cvstakehome.ui.details

import android.text.Html
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.bambeach.cvstakehome.model.Image

@Composable
fun DetailsScreen(
    image: Image,
    uiState: DetailsUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .verticalScroll(rememberScrollState())
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        AsyncImage(
            model = image.url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        if (image.title.isBlank().not()) {
            Text(
                text = image.title,
                color = Color.White,
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            )
        }
        Text(
            text = Html.fromHtml(image.description, Html.FROM_HTML_MODE_LEGACY).toString(),
            color = Color.White,
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        )
        Text(
            text = image.date,
            color = Color.White,
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        )
    }
}