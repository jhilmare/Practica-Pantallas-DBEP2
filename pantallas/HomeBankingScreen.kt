package com.example.pruebas

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.SwapHoriz
import androidx.compose.material.icons.outlined.TrendingDown
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ServicioBanco(
    val titulo: String,
    val subtitulo: String,
    val icono: ImageVector
)

data class ItemNavegacionBanco(
    val titulo: String,
    val icono: ImageVector
)

@Composable
fun InicioBancoScreen() {
    val servicios = listOf(
        ServicioBanco("Cuenta", "Ver detalles", Icons.Outlined.AccountBalanceWallet),
        ServicioBanco("Transferir", "Fondos", Icons.Outlined.SwapHoriz),
        ServicioBanco("Depositar", "Dinero", Icons.Outlined.TrendingDown),
        ServicioBanco("Retirar", "Dinero", Icons.Outlined.TrendingUp),
        ServicioBanco("Recarga", "Celular", Icons.Outlined.PhoneAndroid),
        ServicioBanco("Pago de", "Servicios", Icons.Outlined.ReceiptLong),
        ServicioBanco("Tarjeta", "Crédito", Icons.Outlined.CreditCard),
        ServicioBanco("Beneficiario", "Agregar", Icons.Outlined.Person)
    )

    Scaffold(
        containerColor = Color(0xFFF8F8F8),
        bottomBar = {
            BarraNavegacionBanco()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(18.dp))

            BarraSuperiorBanco()

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Bienvenida",
                color = Color.Black.copy(alpha = 0.55f),
                fontSize = 13.sp
            )

            Text(
                text = "¡Alexa!",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            TarjetaSaldo()

            Spacer(modifier = Modifier.height(18.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 12.dp)
            ) {
                items(servicios) { servicio ->
                    TarjetaServicioBanco(servicio = servicio)
                }
            }
        }
    }
}
@Composable
fun BarraSuperiorBanco() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menú",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = { },
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notificaciones",
                tint = Color(0xFFFF6B8A)
            )
        }
    }
}
@Composable
fun TarjetaSaldo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(165.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF5754D9)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = "Saldo disponible",
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "S/ 12,850",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "BANCO",
                color = Color(0xFF6DFF6A),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.TopEnd)
            )

            Row(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "****  ****  3457  3506",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(70.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White.copy(alpha = 0.15f),
                        shape = CircleShape
                    )
            )

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(38.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White.copy(alpha = 0.12f),
                        shape = CircleShape
                    )
            )
        }
    }
}

@Composable
fun TarjetaServicioBanco(
    servicio: ServicioBanco
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(82.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = servicio.titulo,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = servicio.subtitulo,
                    color = Color.Gray,
                    fontSize = 11.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFEEF2)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = servicio.icono,
                    contentDescription = servicio.titulo,
                    tint = Color(0xFFFF6B8A),
                    modifier = Modifier.size(21.dp)
                )
            }
        }
    }
}
@Composable
fun BarraNavegacionBanco() {
    val items = listOf(
        ItemNavegacionBanco("Inicio", Icons.Outlined.Home),
        ItemNavegacionBanco("Tarjetas", Icons.Outlined.CreditCard),
        ItemNavegacionBanco("Escanear", Icons.Outlined.QrCode),
        ItemNavegacionBanco("Perfil", Icons.Outlined.Person)
    )

    var itemSeleccionado by remember {
        mutableIntStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        shadowElevation = 8.dp
    ) {
        NavigationBar(
            containerColor = Color.White,
            tonalElevation = 0.dp
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = itemSeleccionado == index,
                    onClick = {
                        itemSeleccionado = index
                    },
                    icon = {
                        Icon(
                            imageVector = item.icono,
                            contentDescription = item.titulo
                        )
                    },
                    label = {
                        Text(
                            text = item.titulo,
                            fontSize = 11.sp
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF5754D9),
                        selectedTextColor = Color(0xFF5754D9),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color(0xFFEDEBFF)
                    )
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioBancoScreenPreview() {
    InicioBancoScreen()
}