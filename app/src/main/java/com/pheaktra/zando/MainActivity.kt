package com.pheaktra.zando

import com.pheaktra.zando.ui.screens.LoginScreen
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.pheaktra.zando.themes.ZandoTheme
import com.pheaktra.zando.ui.screens.CategoryScreen
import com.pheaktra.zando.ui.screens.ContactScreen
import com.pheaktra.zando.ui.screens.FirstLook
import com.pheaktra.zando.ui.screens.MainScreen
import com.pheaktra.zando.ui.screens.MenuScreen
import com.pheaktra.zando.ui.screens.ProductDetailScreen
import com.pheaktra.zando.ui.screens.ProfileScreen
import com.pheaktra.zando.ui.screens.RegisterScreen
import com.pheaktra.zando.ui.screens.SearchScreen
import com.pheaktra.zando.ui.screens.WishListScreen
import com.pheaktra.zando.utils.LanguageUtils
import com.pheaktra.zando.viewmodel.LoginViewModel
import com.pheaktra.zando.viewmodel.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                val themeViewModel: ThemeViewModel = viewModel()

                // Observe the dark mode state and selected language
                val isDarkMode by themeViewModel.isDarkMode.collectAsState()
                val selectedLanguage by themeViewModel.selectedLanguage.collectAsState()

                // Apply the stored language setting
                val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
                val savedLanguage = sharedPreferences.getString("language", "en") ?: "en"
                LanguageUtils.setAppLocale(this, savedLanguage)

                // Force recomposition on language change
                var key by remember { mutableStateOf(0) }

                LaunchedEffect(selectedLanguage) {
                    key++
                }

                ZandoTheme(viewModel = themeViewModel) {
                    AppNavHost(isDarkMode = isDarkMode, themeViewModel = themeViewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavHost(isDarkMode: Boolean, themeViewModel: ThemeViewModel) {
    val navController = rememberNavController()
    var showFirstLook by remember { mutableStateOf(true) }
    val loginViewModel: LoginViewModel = viewModel()

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)
        showFirstLook = false
    }

    if (showFirstLook) {
        FirstLook() // Assuming this composable is defined elsewhere
    } else {
        NavHost(
            navController = navController,
            startDestination = "main_screen",
            modifier = Modifier // Added Modifier here
        ) {
            composable("main_screen") { MainScreen(navController) }
            composable("menu_screen") { MenuScreen(navController) }
            composable("search_screen") { SearchScreen(navController) }
            composable("wishlist_screen") { WishListScreen(navController) }
            composable("contact_us") { ContactScreen(navController) }
            composable("register_screen") { RegisterScreen(navController) }
            composable("login_screen") { LoginScreen(navController, loginViewModel) }
            composable("profile_screen") {
                ProfileScreen(
                    navController = navController,
                    viewModel = loginViewModel,
                    themeViewModel = themeViewModel
                )
            }
            composable(
                route = "product_details/{productId}/{category}",
                arguments = listOf(
                    navArgument("productId") { type = NavType.IntType },
                    navArgument("category") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                val category = backStackEntry.arguments?.getString("category") ?: "Men"
                ProductDetailScreen(navController, productId, category)
            }
            composable(
                route = "category_screen/{category}",
                arguments = listOf(navArgument("category") { type = NavType.StringType })
            ) { backStackEntry ->
                val category = backStackEntry.arguments?.getString("category") ?: "Women"
                CategoryScreen(navController, category)
            }
        }
    }
}
