package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pheaktra.zando.R
import com.pheaktra.zando.ui.components.BottomNavigationBar
import com.pheaktra.zando.viewmodel.LoginViewModel
import com.pheaktra.zando.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: LoginViewModel,
    themeViewModel: ThemeViewModel
) {
    val context = LocalContext.current
    val isLoggedIn by viewModel.isLoggedIn
    val username by viewModel.username
    val selectedLanguage by themeViewModel.selectedLanguage.collectAsState()
    val isDarkMode by themeViewModel.isDarkMode.collectAsState()
    var selectedTab by remember { mutableStateOf(4) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = username ?: stringResource(R.string.profile_me),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground, // Adaptive text color
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                if (!isLoggedIn) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = { navController.navigate("register_screen") },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = MaterialTheme.colorScheme.onBackground // Adaptive color
                            )
                        ) {
                            Text(text = stringResource(R.string.register))
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = { navController.navigate("login_screen") },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,
                                contentColor = Color.White // Always white text
                            )
                        ) {
                            Text(text = stringResource(R.string.login))
                        }
                    }
                } else {
                    Button(
                        onClick = {
                            viewModel.logOut()
                            navController.navigate("profile_screen")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White // Always white text
                        )
                    ) {
                        Text(text = stringResource(R.string.logout))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.language),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground // Adaptive color
                )

                LanguageOption("English", selectedLanguage == "en") {
                    if (selectedLanguage != "en") {
                        themeViewModel.setLanguage("en")
                    }
                }

                LanguageOption("ខ្មែរ", selectedLanguage == "km") {
                    if (selectedLanguage != "km") {
                        themeViewModel.setLanguage("km")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = { navController.navigate("contact_us") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onBackground // Adaptive color
                    )
                ) {
                    Text(text = stringResource(R.string.contact_us))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(R.string.settings),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground // Adaptive color
                )

                // Dark Mode toggle
                DarkModeOption(selected = isDarkMode) {
                    themeViewModel.toggleDarkMode()
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                navController = navController,
                onTabSelected = { selectedTab = it }
            )
        }
    )
}

@Composable
fun LanguageOption(text: String, selected: Boolean, onSelect: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground // Adaptive text color
        )
        Spacer(modifier = Modifier.weight(1f))
        RadioButton(selected = selected, onClick = onSelect)
    }
}

@Composable
fun DarkModeOption(selected: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.dark_mode),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground // Adaptive text color
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = selected, onCheckedChange = onCheckedChange)
    }
}
