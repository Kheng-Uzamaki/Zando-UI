package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pheaktra.zando.ui.components.BottomNavigationBar
import com.pheaktra.zando.ui.components.CollectionSection
import com.pheaktra.zando.ui.components.FooterSection
import com.pheaktra.zando.ui.components.ImageSlider
import com.pheaktra.zando.ui.components.ProductMenArrival
import com.pheaktra.zando.ui.components.ProductWomenArrival

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor = Color.White,
//                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        text = "ZANDO",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle Notifications */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle Shopping Bag */ }) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingBag,
                            contentDescription = "Shopping Bag"
                        )
                    }
                    IconButton(onClick = { navController.navigate("profile_screen") }) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedTab, navController) { selectedTab = it }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { ImageSlider() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { CollectionSection() }
            item { ProductWomenArrival(navController) }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { ProductMenArrival(navController) }
            item { FooterSection() }
        }
    }
}
