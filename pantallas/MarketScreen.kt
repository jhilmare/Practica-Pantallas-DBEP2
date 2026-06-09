package com.example.tuapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

data class MarketItem(
    val username: String,
    val price: String,
    val avatarColor: Color
)

@Composable
fun MarketScreen() {
    val items = listOf(
        MarketItem("Jhon", "$1", Color(0xFF00A8A8)),
        MarketItem("Jhilmar", "$1", Color(0xFFFF4F7B)),
        MarketItem("Otazu", "$1", Color(0xFF35C759)),
        MarketItem("Luna", "$1", Color(0xFFFF5E8A)),
        MarketItem("@nadsa", "$1", Color(0xFF8E44AD)),
        MarketItem("@orb_vector_856", "$1", Color(0xFF1E3A8A)),
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp, vertical = 18.dp)
        ) {
            Text(
                text = "Tienda",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Varias cosas que podes comprar.",
                fontSize = 13.sp,
                color = Color.Black.copy(alpha = 0.65f)
            )

            Spacer(modifier = Modifier.height(14.dp))

            MarketFilterChips()

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 12.dp)
            ) {
                items(items) { item ->
                    MarketListItem(item = item)
                }
            }
        }
    }
}
@Composable
fun MarketFilterChips() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        MarketChip(
            text = "Top Handles",
            selected = false
        )

        MarketChip(
            text = "Legendary",
            selected = false
        )

        MarketChip(
            text = "By Price ↕",
            selected = true
        )

        MarketChip(
            text = "Newest",
            selected = false
        )
    }
}

@Composable
fun MarketChip(
    text: String,
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(
                if (selected) Color.Black
                else Color(0xFFF0F0F0)
            )
            .padding(horizontal = 13.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            color = if (selected) Color.White else Color.Black.copy(alpha = 0.75f)
        )
    }
}
@Composable
fun MarketListItem(
    item: MarketItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFF4F4F4))
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AvatarCircle(color = item.avatarColor)

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = item.username,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = item.price,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = { },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 0.dp),
            modifier = Modifier.height(34.dp)
        ) {
            Text(
                text = "Buy",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun AvatarCircle(
    color: Color
) {
    Box(
        modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.7f),
                        color,
                        Color.Black.copy(alpha = 0.25f)
                    )
                )
            )
            .border(
                width = 1.dp,
                color = Color.White,
                shape = CircleShape
            )
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MarketScreenPreview() {
    MarketScreen()
}