package com.vedant.caregiverapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.*

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    var showShiftRequest by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            if (!showShiftRequest) {
                BottomNavigationBar(selectedTab) { selectedTab = it }
            }
        },
        backgroundColor = Color(0xFFF9FAFF)
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            when {
                showShiftRequest -> ShiftRequestScreen(
                    onBack = { showShiftRequest = false }
                )
                selectedTab == 0 -> HomeScreenContent(
                    onBookNow = { showShiftRequest = true }
                )
                selectedTab == 1 -> ShiftsScreen()

            }
        }
    }
}

@Composable
fun HomeScreenContent(onBookNow: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))
        OfferSection()
        Spacer(modifier = Modifier.height(16.dp))
        RecommendationSection(onBookNow = onBookNow)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun HeaderSection() {
    Image(
        painter = painterResource(id = R.drawable.header), // your image name
        contentDescription = "Header",
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp), // Adjust height as needed
        contentScale = ContentScale.Crop // or ContentScale.FillWidth
    )
}
@Composable
fun CategorySection() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Category", fontWeight = FontWeight.Medium, fontSize = 17.sp, color = Color(0xFF222B45))
            Text("See all", color = Color(0xFF1976F3), fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CategoryChip("Day Care", selected = true)
            CategoryChip("Professional Care")
            CategoryChip("Family Care")
        }
    }
}

@Composable
fun CategoryChip(text: String, selected: Boolean = false) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (selected) Color(0xFF1976F3) else Color.White,
        border = if (!selected) BorderStroke(1.dp, Color(0xFF1976F3)) else null,
        elevation = 2.dp
    ) {
        Text(
            text,
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),
            color = if (selected) Color.White else Color(0xFF1976F3),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun OfferSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color(0xFF1976F3).copy(alpha = 0.12f),
            elevation = 0.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "Upto 20% off",
                        color = Color(0xFF1976F3),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        "Caregiving at reasonable price",
                        color = Color(0xFF1976F3),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1976F3)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.elevation(0.dp)
                    ) {
                        Text("Book Now", color = Color.White, fontSize = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.offer),
                    contentDescription = "Offer Illustration",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun RecommendationSection(onBookNow: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Recommendation Shifts", fontWeight = FontWeight.Medium, fontSize = 17.sp, color = Color(0xFF222B45))
            Text("See all", color = Color(0xFF1976F3), fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        RecommendationCard(
            avatar = R.drawable.nurse_1,
            name = "Snehal Damle",
            role = "Day Care Specialist",
            description = "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence.",
            rating = 5.0,
            reviews = 33,
            location = "Loni Kalbhor",
            price = "₹400/hr",
            onBookNow = onBookNow
        )
        RecommendationCard(
            avatar = R.drawable.nurse_2,
            name = "Ravi Sen",
            role = "Care Specialist",
            description = "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence.",
            rating = 5.0,
            reviews = 33,
            location = "Loni Kalbhor",
            price = "₹400/hr"
        )
    }
}

@Composable
fun RecommendationCard(
    avatar: Int,
    name: String,
    role: String,
    description: String,
    rating: Double,
    reviews: Int,
    location: String,
    price: String,
    onBookNow: (() -> Unit)? = null

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
                    onClick = { if (name == "Snehal Damle") onBookNow?.invoke() },
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
@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 16.dp
    ) {
        BottomNavigationItem(
            icon = {
                Image(
                    painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(65.dp) // Increase size here
                )
            },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painterResource(id = R.drawable.shifts),
                    contentDescription = "Shifts",
                    modifier = Modifier.size(32.dp)
                )
            },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painterResource(id = R.drawable.wallet),
                    contentDescription = "Wallet",
                    modifier = Modifier.size(32.dp)
                )
            },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) }
        )
    }
}