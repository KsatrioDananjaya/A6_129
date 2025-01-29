package com.example.a6129.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun HomeApp(
    onNavigateBack: () -> Unit = { },
    onAcara: () -> Unit = { },
    onKlien: () -> Unit = { },
    onLokasi: () -> Unit = { },
    onVendor: () -> Unit = { },
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF81D4FA),
                        Color(0xFFFFFFFF)
                    ),
                    start = Offset(1f, 0f),
                    end = Offset(0f, 1f)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 300.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clickable { onAcara() },
                    elevation = CardDefaults.cardElevation(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA500)) // Dark Orange
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Acara Icon",
                                modifier = Modifier.size(60.dp).background(color = Color.White.copy(alpha = 0.2f), shape = CircleShape).padding(12.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Acara", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clickable { onKlien() },
                    elevation = CardDefaults.cardElevation(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA500)) // Dark Orange
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = "Klien Icon",
                                modifier = Modifier.size(60.dp).background(color = Color.White.copy(alpha = 0.2f), shape = CircleShape).padding(12.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Klien", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clickable { onLokasi() },
                    elevation = CardDefaults.cardElevation(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA500)) // Dark Orange
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Lokasi Icon",
                                modifier = Modifier.size(60.dp).background(color = Color.White.copy(alpha = 0.2f), shape = CircleShape).padding(12.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Lokasi", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clickable { onVendor() },
                    elevation = CardDefaults.cardElevation(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA500)) // Dark Orange
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Vendor Icon",
                                modifier = Modifier.size(60.dp).background(color = Color.White.copy(alpha = 0.2f), shape = CircleShape).padding(12.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Vendor", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }

        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2E7D32)),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
                .width(300.dp)
                .height(150.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "UAS A6", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Ksatrio Dananjaya", fontSize = 18.sp, color = Color.White)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "20200140129", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }
}