package com.pheaktra.zando.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.pheaktra.zando.R

@Composable
fun BottomNavigationBar(selectedTab: Int, navController: NavController, onTabSelected: (Int) -> Unit) {
    NavigationBar() {

        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Home, contentDescription = "Home") },
            label = { Text(text = stringResource(R.string.home_nav)) },
            selected = selectedTab == 0,
            onClick = {
                onTabSelected(0)
                navController.navigate("main_screen")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Menu, contentDescription = "Menu") },
            label = { Text(text = stringResource(R.string.menu_nav)) },
            selected = selectedTab == 1,
            onClick = {
                onTabSelected(1)
                navController.navigate("menu_screen")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
            label = { Text(text = stringResource(R.string.search_nav)) },
            selected = selectedTab == 2,
            onClick = {
                onTabSelected(2)
                navController.navigate("search_screen") {
                    popUpTo("main_screen") { inclusive = false }
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Wish List") },
            label = { Text(text = stringResource(R.string.wish_nav)) },
            selected = selectedTab == 3,
            onClick = {
                onTabSelected(3)
                navController.navigate("wishlist_screen")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Person, contentDescription = "Me") },
            label = { Text(text = stringResource(R.string.me_nav)) },
            selected = selectedTab == 4,
            onClick = {
                onTabSelected(4)
                navController.navigate("profile_screen")
            }
        )
    }
}
