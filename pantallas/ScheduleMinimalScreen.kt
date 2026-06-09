package com.example.pruebas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class OpcionAcceso(
    val icono: ImageVector,
    val descripcion: String
)

@Composable
fun HorarioAncladoScreen() {
    val opciones = listOf(
        OpcionAcceso(Icons.Outlined.CalendarMonth, "Calendario"),
        OpcionAcceso(Icons.Outlined.Person, "Perfil"),
        OpcionAcceso(Icons.Outlined.ReceiptLong, "Notas"),
        OpcionAcceso(Icons.Outlined.LocationOn, "Ubicación"),
        OpcionAcceso(Icons.Outlined.Favorite, "Favoritos"),
        OpcionAcceso(Icons.Outlined.Medication, "Medicina")
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF6F6F6)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {

            // Tarjeta de hora anclada abajo a la izquierda
            TarjetaHoraAnclada(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp, bottom = 150.dp)
            )

            // Panel derecho anclado abajo a la derecha, pero más arriba
            PanelRecordatorios(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp, bottom = 146.dp)
            )

            // Cuadrícula de iconos abajo a la izquierda
            CuadriculaAccesos(
                items = opciones,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp, bottom = 16.dp)
            )
        }
    }
}
@Composable
fun TarjetaHoraAnclada(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(138.dp)
            .height(42.dp),
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1FF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "07:00",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF26264D)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { },
                modifier = Modifier.height(28.dp),
                shape = RoundedCornerShape(2.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7A3FF2),
                    contentColor = Color.White
                ),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    horizontal = 10.dp,
                    vertical = 0.dp
                )
            ) {
                Text(
                    text = "+ Lorem",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Composable
fun PanelRecordatorios(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TarjetaRecordatorio(
            icono = Icons.Outlined.LocalOffer,
            titulo = "Ipsum dolor",
            subtitulo = "Dolor sit amet",
            precio = "9$"
        )

        TarjetaRecordatorio(
            icono = Icons.Outlined.Medication,
            titulo = "Ipsum dolor",
            subtitulo = "Dolor sit amet",
            precio = "7$"
        )
    }
}
@Composable
fun TarjetaRecordatorio(
    icono: ImageVector,
    titulo: String,
    subtitulo: String,
    precio: String
) {
    Card(
        modifier = Modifier
            .width(156.dp)
            .height(50.dp),
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF4F3FF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = Color(0xFFEDE7FF),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icono,
                        contentDescription = titulo,
                        tint = Color(0xFF7A3FF2),
                        modifier = Modifier.size(14.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = titulo,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2A2A47)
                    )
                    Text(
                        text = subtitulo,
                        fontSize = 8.sp,
                        color = Color.Gray
                    )
                }
            }

            Box(
                modifier = Modifier
                    .width(36.dp)
                    .height(50.dp)
                    .background(Color(0xFF7A3FF2)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = precio,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Composable
fun CuadriculaAccesos(
    items: List<OpcionAcceso>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(126.dp)
            .height(126.dp),
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF4F3FF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BotonCircularAcceso(items[0])
                BotonCircularAcceso(items[1])
                BotonCircularAcceso(items[2])
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BotonCircularAcceso(items[3])
                BotonCircularAcceso(items[4])
                BotonCircularAcceso(items[5])
            }
        }
    }
}
@Composable
fun BotonCircularAcceso(
    item: OpcionAcceso
) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape,
                ambientColor = Color(0xFF7A3FF2).copy(alpha = 0.25f),
                spotColor = Color(0xFF7A3FF2).copy(alpha = 0.25f)
            )
            .background(Color.White, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = item.icono,
            contentDescription = item.descripcion,
            tint = Color(0xFF7A3FF2),
            modifier = Modifier.size(15.dp)
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HorarioAncladoScreenPreview() {
    HorarioAncladoScreen()
}