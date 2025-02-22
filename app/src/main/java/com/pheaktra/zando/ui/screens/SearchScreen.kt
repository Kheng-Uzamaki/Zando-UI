package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pheaktra.zando.R
import com.pheaktra.zando.ui.components.BottomNavigationBar

@Composable
fun SearchScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf(2) }

    // Sample data
    val productNames = listOf("Nike Air Max", "Adidas Ultraboost", "Puma Runner", "Elegant Dress", "Summer Blouse", "Stylish Skirt")

    // Ensure filtering updates with searchQuery
    val filteredProducts by remember(searchQuery) {
        mutableStateOf(productNames.filter { it.contains(searchQuery, ignoreCase = true) })
    }

    Scaffold(
        topBar = {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.search),
                        modifier = Modifier
                            .weight(1f)
                            .offset(x = 20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = { /* Handle Shopping Bag */ }) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingBag,
                            contentDescription = "Shopping Bag"
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                navController = navController,
                onTabSelected = { selectedTab = it }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                    },
                    placeholder = { Text(text = stringResource(R.string.search_text)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(8.dp)),
                    leadingIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                        }
                    },
                    trailingIcon = {
                        Row {
                            IconButton(onClick = { /* Handle QR Code */ }) {
                                Icon(Icons.Outlined.QrCode, contentDescription = "QR Code")
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Displaying filtered results
                if (filteredProducts.isEmpty()) {
                    Text(
                        text = "No results found.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                } else {
                    LazyColumn {
                        items(filteredProducts) { product ->
                            // Determine category based on product name
                            val category = if (product.contains("Nike") || product.contains("Adidas")) "Men" else "Women"

                            Text(
                                text = product,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        // Navigate to the product details screen
                                        val productId = productNames.indexOf(product) // Using the index as product ID
                                        navController.navigate("product_details/$productId/$category")
                                    }
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}
