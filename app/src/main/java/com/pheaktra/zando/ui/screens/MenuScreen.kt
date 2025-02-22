package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pheaktra.zando.R
import com.pheaktra.zando.ui.components.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(1) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab, navController) { selectedTab = it }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 24.dp, top = 48.dp)
        ) {
            Text(
                text = stringResource(R.string.menu_women),
                fontSize = 50.sp,
                modifier = Modifier.clickable {
                    navController.navigate("category_screen/Women") // Navigate to Women Category
                }
            )

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = stringResource(R.string.menu_men),
                fontSize = 50.sp,
                modifier = Modifier.clickable {
                    navController.navigate("category_screen/Men") // Navigate to Men Category
                }
            )
        }
    }
}
