package com.vedant.caregiverapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShiftRequestScreen(
    onBack: () -> Unit = {},
    onWishlist: () -> Unit = {},
    onSchedule: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        color = Color.White,
        shape = RoundedCornerShape(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF6C63FF),
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "Shift Request",
                    color = Color(0xFF6C63FF),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.snehadamle),
                contentDescription = "Nurse Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Sneha Damle",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF222B45),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                "Day Care Specialist",
                color = Color(0xFF6C63FF),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Star, contentDescription = "Star", tint = Color(0xFFFFC107), modifier = Modifier.size(16.dp))
                Text(" 5.0 (33 reviews)", fontSize = 13.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color.Gray, modifier = Modifier.size(16.dp))
                Text(" Loni Kalbhor", fontSize = 13.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text("₹400/hr", fontSize = 13.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Languages",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Text(" English, Marathi, Hindi", fontSize = 13.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(18.dp))
            Text("Description", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF222B45))
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                "Certified Nursing Assistant (CNA) who has seamlessly blended her passion for patient care with her commitment to medical excellence. With a profound belief in the importance of compassionate healthcare.",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text("Total shifts completed: ", fontSize = 15.sp, color = Color.Gray)
            Text("20", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(0xFF222B45))
            Spacer(modifier = Modifier.height(2.dp))
            Text("Years of experience: ", fontSize = 15.sp, color = Color.Gray)
            Text("5+", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(0xFF222B45))
            Spacer(modifier = Modifier.height(14.dp))
            Text("Reviews", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF222B45))
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    color = Color(0x333381FF),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        "“Very good experience”\n–Sanchita Rathod",
                        fontSize = 13.sp,
                        color = Color(0x99151515),
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Surface(
                    color = Color(0x333381FF),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        "“Nurse was very patient”\n–Tej",
                        fontSize = 13.sp,
                        color = Color(0x99151515),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = onWishlist,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedBorder.copy(width = 2.dp, )
                ) {
                    Text("Whislist", color = Color(0xFF6C63FF), fontSize = 16.sp)
                }
                Button(
                    onClick = onSchedule,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6C63FF))
                ) {
                    Text("Schedule", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}