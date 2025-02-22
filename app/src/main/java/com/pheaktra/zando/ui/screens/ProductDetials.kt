package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pheaktra.zando.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController, productId: Int, category: String) {
    val productImagesMen = listOf(R.drawable.men1, R.drawable.men2, R.drawable.men3)
    val productNamesMen = listOf("Nike Air Max", "Adidas Ultraboost", "Puma Runner")
    val productPricesMen = listOf("$129.99", "$99.99", "$89.99")

    val productImagesWomen = listOf(R.drawable.women1, R.drawable.women2, R.drawable.women3)
    val productNamesWomen = listOf("Elegant Dress", "Summer Blouse", "Stylish Skirt")
    val productPricesWomen = listOf("$79.99", "$59.99", "$49.99")

    // Choose product list based on category
    val productImages = if (category == "Men") productImagesMen else productImagesWomen
    val productNames = if (category == "Men") productNamesMen else productNamesWomen
    val productPrices = if (category == "Men") productPricesMen else productPricesWomen

    var selectedSize by remember { mutableStateOf("M") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.pro_detail)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(Color.White)
        ) {
            Image(
                painter = painterResource(id = productImages.getOrElse(productId) { R.drawable.men1 }),
                contentDescription = "Product Image",
                modifier = Modifier.fillMaxWidth().height(300.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(productNames.getOrElse(productId) { "Unknown Product" }, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(productPrices.getOrElse(productId) { "$0.00" }, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Red)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = stringResource(R.string.pro_desc),
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Size Selection
            Text(text = stringResource(R.string.select_size), modifier = Modifier.padding(horizontal = 16.dp), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row (modifier = Modifier.padding(horizontal = 16.dp)) {
                listOf("S", "M", "L", "XL").forEach { size ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(
                                if (selectedSize == size) Color.Black else Color.LightGray,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable { selectedSize = size }
                    ) {
                        Text(size, color = Color.White, fontSize = 16.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Handle Add to Cart */ },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = stringResource(R.string.add_to_cart))
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { /* Handle Buy Now */ },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = stringResource(R.string.buy), color = Color.White)
                }
            }
        }
    }
}
