package com.example.auri_frontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.auri_frontend.R
import com.example.auri_frontend.ui.theme.Purple40

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onBackClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    var senhaVisivel by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Entrar",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        senhaVisivel = !senhaVisivel
                    }) {
                        Icon(
                            painter = painterResource(
                                id = if (senhaVisivel) R.drawable.ic_eye
                                else R.drawable.ic_eyehide
                            ),
                            contentDescription = "Mostrar/Ocultar Senha",
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            )

            Button(
                onClick = { onLoginSuccess() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Entrar", fontSize = 18.sp)
            }

            TextButton(
                onClick = { onBackClick() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar")
            }
        }
    }
}
