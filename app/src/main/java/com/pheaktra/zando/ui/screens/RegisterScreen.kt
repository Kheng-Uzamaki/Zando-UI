package com.pheaktra.zando.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pheaktra.zando.R

@Composable
fun RegisterScreen(navController: NavController) {
    var gender by rememberSaveable { mutableStateOf("") }
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var mobileNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var birthdate by rememberSaveable { mutableStateOf("") }
    val country by remember { mutableStateOf("Cambodia") }
    var city by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // ❌ Close Button (Top Right)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Outlined.Close, contentDescription = stringResource(R.string.close))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🏷️ Title: Register
        Text(
            text = stringResource(R.string.register),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // ⚥ Gender Selection
        Text(text = stringResource(R.string.gender), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = gender == "Male", onClick = { gender = "Male" })
            Text(text = stringResource(R.string.male), modifier = Modifier.clickable { gender = "Male" })

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(selected = gender == "Female", onClick = { gender = "Female" })
            Text(text = stringResource(R.string.female), modifier = Modifier.clickable { gender = "Female" })
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 👤 Name Fields (First Name & Last Name)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = firstName, onValueChange = { firstName = it },
                label = { Text(stringResource(R.string.first_name)) },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = lastName, onValueChange = { lastName = it },
                label = { Text(stringResource(R.string.last_name)) },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 📲 Mobile Number Field
        OutlinedTextField(
            value = mobileNumber, onValueChange = { mobileNumber = it },
            label = { Text(stringResource(R.string.mobile_number)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 📧 Email Field
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(stringResource(R.string.email)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🎂 Birthdate Field
        OutlinedTextField(
            value = birthdate, onValueChange = { birthdate = it },
            label = { Text(stringResource(R.string.birthdate)) },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = stringResource(R.string.birthdate_note),
            fontSize = 12.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🌍 Country & City Selection
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = country, onValueChange = {},
                label = { Text(stringResource(R.string.country)) },
                modifier = Modifier.weight(1f),
                enabled = false // Static "Cambodia"
            )
            OutlinedTextField(
                value = city, onValueChange = { city = it },
                label = { Text(stringResource(R.string.city)) },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 🔲 Create Account Button
        Button(
            onClick = { /* Handle Registration */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = stringResource(R.string.create_account), color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}
