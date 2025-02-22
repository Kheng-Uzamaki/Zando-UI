package com.pheaktra.zando.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.rememberAsyncImagePainter
import com.pheaktra.zando.R

@Preview
@Composable
fun ImageSlider() {
    val imageList = listOf(
        R.drawable.img,
        R.drawable.bg2,
        R.drawable.bg3,
        R.drawable.bg4
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(imageList) { imageRes ->
                val painter: Painter = rememberAsyncImagePainter(imageRes)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .fillParentMaxSize()
                )
            }
        }
    }
}
