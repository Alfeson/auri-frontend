package com.example.auri_frontend

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.sp
import com.example.auri_frontend.ui.theme.Purple40
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun AddButton(
    onSaveClick: (String, Bitmap?) -> Unit,
    onBackClick: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    val context = LocalContext.current

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            val source = ImageDecoder.createSource(context.contentResolver, uri)
            imageBitmap = ImageDecoder.decodeBitmap(source)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Purple40, Color(0xFFB388FF))
                )
            )
            .padding(horizontal = 24.dp, vertical = 36.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = "Adicionar Fala",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White.copy(alpha = 0.15f), shape = RoundedCornerShape(20.dp))
                    .clickable {
                        imagePicker.launch("image/*")
                    },
                contentAlignment = Alignment.Center
            ) {

                if (imageBitmap == null) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.puzzle_icon),
                            contentDescription = "Adicionar imagem",
                            tint = Color.White,
                            modifier = Modifier.size(64.dp)
                        )
                        Text(
                            text = "Adicionar Imagem",
                            color = Color.White.copy(alpha = 0.9f),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                } else {
                    Image(
                        bitmap = imageBitmap!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Digite a fala") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White.copy(alpha = 0.1f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.05f),
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White.copy(alpha = 0.7f),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    onClick = {
                        if (text.isNotBlank()) onSaveClick(text, imageBitmap)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        "Salvar",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                TextButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        "Voltar",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

