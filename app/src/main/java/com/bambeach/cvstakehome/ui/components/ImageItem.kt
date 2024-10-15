package com.bambeach.cvstakehome.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bambeach.cvstakehome.R
import com.bambeach.cvstakehome.data.sampleImage
import com.bambeach.cvstakehome.model.Image

@Composable
fun ImageItem(
    image: Image,
    modifier: Modifier = Modifier,
    onImageClick: (Image) -> Unit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image.url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_android_black),
        contentDescription = image.title,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clickable { onImageClick(image) }
            .size(150.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Preview
@Composable
fun ImageItemPreview() {
    ImageItem(sampleImage) { }
}