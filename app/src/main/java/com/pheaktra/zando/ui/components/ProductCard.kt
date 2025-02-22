package com.pheaktra.zando.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.rememberAsyncImagePainter
import com.pheaktra.zando.R

// Product Data
val productImagesMen = listOf(R.drawable.men1, R.drawable.men2, R.drawable.men3)
val productNamesMen = listOf("Nike Air Max", "Adidas Ultraboost", "Puma Runner")
val productPricesMen = listOf("$129.99", "$99.99", "$89.99")

val productImagesWomen = listOf(R.drawable.women1, R.drawable.women2, R.drawable.women3)
val productNamesWomen = listOf("Elegant Dress", "Summer Blouse", "Stylish Skirt")
val productPricesWomen = listOf("$79.99", "$59.99", "$49.99")

@Composable
fun ProductCard(imageRes: Int, productId: Int, navController: NavController) {
    val category = if (imageRes in productImagesMen) "Men" else "Women"
    val productName = if (category == "Men") productNamesMen[productImagesMen.indexOf(imageRes)]
    else productNamesWomen[productImagesWomen.indexOf(imageRes)]

    val productPrice = if (category == "Men") productPricesMen[productImagesMen.indexOf(imageRes)]
    else productPricesWomen[productImagesWomen.indexOf(imageRes)]

    Card(
        modifier = Modifier
            .width(190.dp)
            .height(320.dp)
            .clickable {
                navController.navigate("product_details/$productId/$category")
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                val painter: Painter = rememberAsyncImagePainter(imageRes)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Product Name
            Text(
                text = productName,
                color = MaterialTheme.colorScheme.onBackground, // Adaptive text color
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )

            // Price and Favorite Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = productPrice, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                IconButton(onClick = { /* Handle Favorite Click */ }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductCard() {
    val navController = rememberNavController()
    ProductCard(imageRes = R.drawable.men1, productId = 1, navController = navController)
}
