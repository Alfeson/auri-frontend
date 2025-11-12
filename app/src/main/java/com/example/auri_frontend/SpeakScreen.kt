package com.example.auri_frontend

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeakScreen(
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
                        "Adicionar",
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

            Text("Ações", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            ButtonRow {
                SpeakButton("Oi", R.drawable.ic_hi, Modifier.weight(1f)) { onSpeak("Oi") }
            }
            ButtonRow {
                SpeakButton("Comer", R.drawable.ic_food, Modifier.weight(1f)) { onSpeak("Comer") }
                SpeakButton("Beber", R.drawable.ic_drink, Modifier.weight(1f)) { onSpeak("Beber") }
            }

            ButtonRow {
                SpeakButton("Banheiro", R.drawable.ic_bathroom, Modifier.weight(1f)) { onSpeak("Banheiro") }
                SpeakButton("Dormir", R.drawable.ic_sleep, Modifier.weight(1f)) { onSpeak("Dormir") }
            }

            ButtonRow {
                SpeakButton("Brincar", R.drawable.ic_play, Modifier.weight(1f)) { onSpeak("Brincar") }
                SpeakButton("Assistir TV", R.drawable.ic_tv, Modifier.weight(1f)) { onSpeak("Assistir TV") }
            }

            Text("Cores", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            ButtonRow {
                ColorSpeakButton("Vermelho", Color.Red, Modifier.weight(1f)) { onSpeak("Vermelho") }
                ColorSpeakButton("Amarelo", Color.Yellow, Modifier.weight(1f)) { onSpeak("Amarelo") }
            }
            ButtonRow {
                ColorSpeakButton("Verde", Color.Green, Modifier.weight(1f)) { onSpeak("Verde") }
                ColorSpeakButton("Azul", Color.Blue, Modifier.weight(1f)) { onSpeak("Azul") }
            }
            ButtonRow {
                ColorSpeakButton("Roxo", Color(0xFF9C27B0), Modifier.weight(1f)) { onSpeak("Roxo") }
                ColorSpeakButton("Laranja", Color(0xFFFF9800), Modifier.weight(1f)) { onSpeak("Laranja") }
            }
            ButtonRow {
                ColorSpeakButton("Preto", Color.Black, Modifier.weight(1f)) { onSpeak("Preto") }
                ColorSpeakButton("Branco", Color.White, Modifier.weight(1f)) { onSpeak("Branco") }
            }

            Text("Sentimentos", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            ButtonRow {
                SpeakButton("Feliz", R.drawable.ic_happy, Modifier.weight(1f)) { onSpeak("Feliz") }
                SpeakButton("Triste", R.drawable.ic_sad, Modifier.weight(1f)) { onSpeak("Triste") }
            }

            Text("Lugares", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            ButtonRow {
                SpeakButton("Casa", R.drawable.ic_home, Modifier.weight(1f)) { onSpeak("Casa") }
                SpeakButton("Escola", R.drawable.ic_school, Modifier.weight(1f)) { onSpeak("Escola") }
            }

            Text("Rotina", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            ButtonRow {
                SpeakButton("Manhã", R.drawable.ic_morning, Modifier.weight(1f)) { onSpeak("Manhã") }
                SpeakButton("Noite", R.drawable.ic_night, Modifier.weight(1f)) { onSpeak("Noite") }
            }

            ButtonRow {
                SpeakButton("Sim", R.drawable.ic_yes, Modifier.weight(1f)) { onSpeak("Sim") }
                SpeakButton("Não", R.drawable.ic_no, Modifier.weight(1f)) { onSpeak("Não") }
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
fun SpeakButton(text: String, imageRes: Int, modifier: Modifier = Modifier, onClick: () -> Unit) {
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
fun ColorSpeakButton(text: String, color: Color, modifier: Modifier = Modifier, onClick: () -> Unit) {
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