package com.vedant.caregiverapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShiftsScreen(onBack: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFF1976F3))
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "Shifts",
                color = Color(0xFF4B4EF8),
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search Nurses") },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xFFF6F7FB),
                focusedBorderColor = Color(0xFFE3EAFD),
                unfocusedBorderColor = Color(0xFFE3EAFD)
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    tint = Color(0xFFB0B8C1)
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // List of shifts
        ShiftCard(
            avatar = R.drawable.nurse_1,
            name = "Snehal Damle",
            role = "Day Care Specialist",
            description = "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence.",
            rating = 5.0,
            reviews = 33,
            location = "Loni Kalbhor",
            price = "₹400/hr"
        )
        ShiftCard(
            avatar = R.drawable.nurse_2,
            name = "Ravi Sen",
            role = "Care Specialist",
            description = "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence.",
            rating = 5.0,
            reviews = 33,
            location = "Loni Kalbhor",
            price = "₹400/hr"
        )
        ShiftCard(
            avatar = R.drawable.nurse_2,
            name = "Ravi Sen",
            role = "Care Specialist",
            description = "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence.",
            rating = 5.0,
            reviews = 33,
            location = "Loni Kalbhor",
            price = "₹400/hr"
        )
        ShiftCard(
            avatar = R.drawable.nurse_2,
            name = "Ravi Sen",
            role = "Care Specialist",
            description = "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence.",
            rating = 5.0,
            reviews = 33,
            location = "Loni Kalbhor",
            price = "₹400/hr"
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ShiftCard(
    avatar: Int,
    name: String,
    role: String,
    description: String,
    rating: Double,
    reviews: Int,
    location: String,
    price: String
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        elevation = 6.dp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF222B45))
                    Text(role, color = Color(0xFF1976F3), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1976F3)),
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.elevation(0.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text("Book Now", color = Color.White, fontSize = 13.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(description, fontSize = 13.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = "Star", tint = Color(0xFFFFC107), modifier = Modifier.size(16.dp))
                Text("$rating ($reviews reviews)", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color.Gray, modifier = Modifier.size(16.dp))
                Text(location, fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text("₹", color = Color.Gray, fontSize = 14.sp, modifier = Modifier.padding(end = 2.dp))
                Text(price, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}