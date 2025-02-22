package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Facebook
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pheaktra.zando.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(
                        text = stringResource(R.string.contact_us_screen),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().offset(x = -18.dp),
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = stringResource(R.string.contact_title))
                Spacer(modifier = Modifier.height(32.dp))

                // Email Section with Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.contact_email), fontSize = 16.sp)
                }
                Text(text = "hengsokkheng145@gmail.com", fontSize = 16.sp)

                // Divider after "Email"
                Spacer(modifier = Modifier.height(20.dp))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Spacer(modifier = Modifier.height(20.dp))

                // Phone Section with Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = "Phone Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.phone), fontSize = 16.sp)
                }
                Text(text = "(+855) 96 528 4100", fontSize = 16.sp)
                // Divider after "Phone"
                Spacer(modifier = Modifier.height(20.dp))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Spacer(modifier = Modifier.height(20.dp))

                // Facebook Section with Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Facebook,
                        contentDescription = "Facebook",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.facebook), fontSize = 16.sp)
                }
                Text(text = "Heng Sokkheng", fontSize = 16.sp)
                // Divider after "Facebook"
                Spacer(modifier = Modifier.height(20.dp))
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Spacer(modifier = Modifier.height(20.dp))

                //  Telegram with Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.telegram2),
                        contentDescription = "Telegram",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.telegram), fontSize = 16.sp)
                }
                Text(text = "t.me/@Sokkheng_Heng", fontSize = 16.sp)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewContactScreen() {
    ContactScreen(navController = rememberNavController())
}
