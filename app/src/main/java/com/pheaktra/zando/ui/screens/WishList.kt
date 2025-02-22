package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
fun WishListScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(3) }

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
                        text = stringResource(R.string.wish_list),
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

//        topBar = {
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = stringResource(R.string.wish_list),
//                    modifier = Modifier.weight(1f),
//                    textAlign = TextAlign.Center,
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                )
//                IconButton(onClick = { /* Handle Shopping Bag */ }) {
//                    Icon(
//                        imageVector = Icons.Outlined.ShoppingBag,
//                        contentDescription = "Shopping Bag",
//                        tint = Color.Black
//                    )
//                }
//            }
//        },
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
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.empty_wish_list),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.wish_list_description),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {  }, // Navigate to Login screen
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text(stringResource(R.string.start_shopping), color = Color.White)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewWishScreen() {
    WishListScreen(navController = rememberNavController())
}