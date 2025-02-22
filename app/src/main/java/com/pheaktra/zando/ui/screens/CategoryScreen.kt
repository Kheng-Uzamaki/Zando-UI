package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pheaktra.zando.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController, category: String) {
    val productImagesMen = listOf(R.drawable.men1, R.drawable.men2, R.drawable.men3)
    val productNamesMen = listOf("Nike Air Max", "Adidas Ultraboost", "Puma Runner")
    val productPricesMen = listOf("$129.99", "$99.99", "$89.99")

    val productImagesWomen = listOf(R.drawable.women1, R.drawable.women2, R.drawable.women3)
    val productNamesWomen = listOf("Elegant Dress", "Summer Blouse", "Stylish Skirt")
    val productPricesWomen = listOf("$79.99", "$59.99", "$49.99")

    val productImages = if (category == "Men") productImagesMen else productImagesWomen
    val productNames = if (category == "Men") productNamesMen else productNamesWomen
    val productPrices = if (category == "Men") productPricesMen else productPricesWomen

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$category Collection") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(productImages) { index, imageRes ->
                ProductCard(imageRes, productNames[index], productPrices[index], navController)
            }
        }
    }
}

@Composable
fun ProductCard(imageRes: Int, name: String, price: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)
            Text(text = price, fontSize = 18.sp, style = MaterialTheme.typography.bodyMedium, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Navigate to product details screen */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("View Details")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCategoryScreen() {
    val navController = rememberNavController()
    CategoryScreen(navController, category = "Women")
}

