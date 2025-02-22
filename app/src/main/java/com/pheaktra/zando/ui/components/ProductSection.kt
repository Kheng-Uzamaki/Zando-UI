package com.pheaktra.zando.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pheaktra.zando.R

@Composable
fun ProductWomenArrival(navController: NavController) {
    ProductSection(title = stringResource(R.string.pro_sec), category = "Women", navController = navController)
}

@Composable
fun ProductMenArrival(navController: NavController) {
    ProductSection(title = stringResource(R.string.pro_sec), category = "Men", navController = navController)
}


@Composable
fun ProductSection(title: String, category: String, navController: NavController) {
    val imageListMen = listOf(R.drawable.men1, R.drawable.men2, R.drawable.men3)
    val imageListWomen = listOf(R.drawable.women1, R.drawable.women2, R.drawable.women3)

    val imageList = if (category == "Men") imageListMen else imageListWomen

    Column(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(R.string.pro_more), color = Color.Blue)
                IconButton(onClick = { /* TODO: Handle click */ }) {
                    Icon(Icons.Outlined.ArrowForward, contentDescription = "Go to New Arrivals")
                }
            }
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            itemsIndexed(imageList) { index, imageRes ->
                ProductCard(imageRes, index, navController)
            }
        }
    }
}



