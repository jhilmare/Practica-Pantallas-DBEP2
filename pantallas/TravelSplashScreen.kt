package com.example.pruebas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TravelSplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B8FD3)),
        contentAlignment = Alignment.Center
    ) {
        SplashCard {
            SplashContent()
        }
    }
}

@Composable
fun SplashCard(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(36.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF03A9F4),
                        Color(0xFF2196F3),
                        Color(0xFF673AB7)
                    )
                )
            )
            .border(
                border = BorderStroke(4.dp, Color.White),
                shape = RoundedCornerShape(36.dp)
            )
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    border = BorderStroke(1.5.dp, Color.White.copy(alpha = 0.9f)),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
fun SplashContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Travel 🌍",
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Find Your Dream\nDestination With Us",
            color = Color.White.copy(alpha = 0.9f),
            fontSize = 11.sp,
            lineHeight = 15.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TravelSplashScreenPreview() {
    TravelSplashScreen()
}