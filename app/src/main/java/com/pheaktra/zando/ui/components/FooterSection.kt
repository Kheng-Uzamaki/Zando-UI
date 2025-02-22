package com.pheaktra.zando.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactSupport
import androidx.compose.material.icons.outlined.LocalPhone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pheaktra.zando.R

@Preview
@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Loyalty Section
        Text(
            text = stringResource(R.string.footer_loyal),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.membership), // Replace with the correct icon
                contentDescription = "Membership & Benefits",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.footer_member))
        }
        Spacer(modifier = Modifier.height(16.dp))


        // Social Media Section
        Text(text = stringResource(R.string.footer_follow), fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            listOf(
                R.drawable.facebook,
                R.drawable.instagram,
                R.drawable.youtube,
                R.drawable.tiktok
            ).forEach { iconRes ->
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Social Icon",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Customer Services
        Text(text = stringResource(R.string.footer_services), fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.ContactSupport, contentDescription = "Online exchange policy")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.footer_exchange))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.LocalPhone, contentDescription = "Contact Us")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.footer_contact))
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Payment Methods
        Text(text = stringResource(R.string.footer_accept), fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(18.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            listOf(
                R.drawable.acleda,
                R.drawable.visa_pay,
                R.drawable.mastercard_pay,
                R.drawable.union_pay,
                R.drawable.jcb_pay,
            ).forEach { paymentIcon ->
                Image(
                    painter = painterResource(id = paymentIcon),
                    contentDescription = "Payment Method",
                    modifier = Modifier.width(26.dp)
                )
            }
        }
    }
}
