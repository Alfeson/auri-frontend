package com.example.auri_frontend.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auri_frontend.R
import com.example.auri_frontend.components.UserButtonData
import com.example.auri_frontend.components.UserSpeakButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeakScreen(
    userButtons: List<UserButtonData>,
    onBackClick: () -> Unit = {},
    onSpeak: (String) -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Falas") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onAddClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                ) {
                    Text(
                        "Adicionar +",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                "Toque em um ícone para ser lido em voz alta",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            // ---------- AÇÕES ----------
            Text("Ações", fontSize = 18.sp, fontWeight = FontWeight.Medium)

            ButtonRow {
                SpeakButton(
                    text = "Oi",
                    imageRes = R.drawable.ic_hi,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Oi") }
                )
            }

            ButtonRow {
                SpeakButton(
                    text = "Comer",
                    imageRes = R.drawable.ic_food,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Comer") }
                )
                SpeakButton(
                    text = "Beber",
                    imageRes = R.drawable.ic_drink,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Beber") }
                )
            }

            ButtonRow {
                SpeakButton(
                    text = "Banheiro",
                    imageRes = R.drawable.ic_bathroom,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Banheiro") }
                )
                SpeakButton(
                    text = "Dormir",
                    imageRes = R.drawable.ic_sleep,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Dormir") }
                )
            }

            ButtonRow {
                SpeakButton(
                    text = "Brincar",
                    imageRes = R.drawable.ic_play,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Brincar") }
                )
                SpeakButton(
                    text = "Assistir TV",
                    imageRes = R.drawable.ic_tv,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Assistir TV") }
                )
            }

            // ---------- CORES ----------
            Text("Cores", fontSize = 18.sp, fontWeight = FontWeight.Medium)

            ButtonRow {
                ColorSpeakButton(
                    text = "Vermelho",
                    color = Color.Red,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Vermelho") }
                )
                ColorSpeakButton(
                    text = "Amarelo",
                    color = Color.Yellow,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Amarelo") }
                )
            }

            ButtonRow {
                ColorSpeakButton(
                    text = "Verde",
                    color = Color.Green,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Verde") }
                )
                ColorSpeakButton(
                    text = "Azul",
                    color = Color.Blue,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Azul") }
                )
            }

            ButtonRow {
                ColorSpeakButton(
                    text = "Roxo",
                    color = Color(0xFF9C27B0),
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Roxo") }
                )
                ColorSpeakButton(
                    text = "Laranja",
                    color = Color(0xFFFF9800),
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Laranja") }
                )
            }

            ButtonRow {
                ColorSpeakButton(
                    text = "Preto",
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Preto") }
                )
                ColorSpeakButton(
                    text = "Branco",
                    color = Color.White,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Branco") }
                )
            }

            // ---------- SENTIMENTOS ----------
            Text("Sentimentos", fontSize = 18.sp, fontWeight = FontWeight.Medium)

            ButtonRow {
                SpeakButton(
                    text = "Feliz",
                    imageRes = R.drawable.ic_happy,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Feliz") }
                )
                SpeakButton(
                    text = "Triste",
                    imageRes = R.drawable.ic_sad,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Triste") }
                )
            }

            // ---------- LUGARES ----------
            Text("Lugares", fontSize = 18.sp, fontWeight = FontWeight.Medium)

            ButtonRow {
                SpeakButton(
                    text = "Casa",
                    imageRes = R.drawable.ic_home,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Casa") }
                )
                SpeakButton(
                    text = "Escola",
                    imageRes = R.drawable.ic_school,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Escola") }
                )
            }

            // ---------- ROTINA ----------
            Text("Rotina", fontSize = 18.sp, fontWeight = FontWeight.Medium)

            ButtonRow {
                SpeakButton(
                    text = "Manhã",
                    imageRes = R.drawable.ic_morning,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Manhã") }
                )
                SpeakButton(
                    text = "Noite",
                    imageRes = R.drawable.ic_night,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Noite") }
                )
            }

            ButtonRow {
                SpeakButton(
                    text = "Sim",
                    imageRes = R.drawable.ic_yes,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Sim") }
                )
                SpeakButton(
                    text = "Não",
                    imageRes = R.drawable.ic_no,
                    modifier = Modifier.weight(1f),
                    onClick = { onSpeak("Não") }
                )
            }

            // ---------- BOTÕES DO USUÁRIO ----------
            if (userButtons.isNotEmpty()) {
                Text("Minhas Falas", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                userButtons.forEach { item ->
                    UserSpeakButton(
                        text = item.text,
                        image = item.image,
                        onClick = { onSpeak(item.text) }
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonRow(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = content
    )
}

@Composable
fun SpeakButton(
    text: String,
    imageRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.height(120.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = text,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColorSpeakButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.height(100.dp)
    ) {
        Text(
            text = text,
            color = if (color == Color.White) Color.Black else Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
