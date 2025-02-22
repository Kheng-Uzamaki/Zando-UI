package com.pheaktra.zando.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pheaktra.zando.R

@Composable
fun CollectionSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CollectionBox(title = stringResource(R.string.col_men), backgroundColor = Color.Black)
        Spacer(modifier = Modifier.width(8.dp))
        CollectionBox(title = stringResource(R.string.col_women), backgroundColor = Color.Black)
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CollectionBox(title: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(80.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, color = Color.White)
    }
}

