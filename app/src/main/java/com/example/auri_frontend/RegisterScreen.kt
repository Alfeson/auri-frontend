package com.example.auri_frontend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auri_frontend.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onSuccess: () -> Unit = {}) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var ownership by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }

    var dependentName by remember { mutableStateOf(TextFieldValue("")) }
    var dependentLevel by remember { mutableStateOf(TextFieldValue("")) }

    var street by remember { mutableStateOf(TextFieldValue("")) }
    var number by remember { mutableStateOf(TextFieldValue("")) }
    var neighborhood by remember { mutableStateOf(TextFieldValue("")) }
    var city by remember { mutableStateOf(TextFieldValue("")) }
    var state by remember { mutableStateOf(TextFieldValue("")) }
    var country by remember { mutableStateOf(TextFieldValue("")) }

    var message by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Cadastro de Conta", fontWeight = FontWeight.Bold) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Informações daConta",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Purple40
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = ownership,
                onValueChange = { ownership = it },
                label = { Text("Parentesco (Pai, Mãe, Tutor)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Telefone") },
                modifier = Modifier.fillMaxWidth()
            )

            Divider(thickness = 1.dp, color = Color.LightGray.copy(alpha = 0.5f))

            Text(
                "Dependente",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Purple40
            )

            OutlinedTextField(
                value = dependentName,
                onValueChange = { dependentName = it },
                label = { Text("Nome do Dependente") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = dependentLevel,
                onValueChange = { dependentLevel = it },
                label = { Text("Nível (ex: Infantil, Médio, etc.)") },
                modifier = Modifier.fillMaxWidth()
            )

            Divider(thickness = 1.dp, color = Color.LightGray.copy(alpha = 0.5f))

            Text(
                "Endereço",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Purple40
            )

            OutlinedTextField(
                value = street,
                onValueChange = { street = it },
                label = { Text("Rua") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = number,
                onValueChange = { number = it },
                label = { Text("Número") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = neighborhood,
                onValueChange = { neighborhood = it },
                label = { Text("Bairro") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("Cidade") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = state,
                onValueChange = { state = it },
                label = { Text("Estado") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = country,
                onValueChange = { country = it },
                label = { Text("País") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (
                        name.text.isBlank() || ownership.text.isBlank() || phone.text.isBlank() ||
                        dependentName.text.isBlank() || dependentLevel.text.isBlank() ||
                        street.text.isBlank() || number.text.isBlank() ||
                        neighborhood.text.isBlank() || city.text.isBlank() ||
                        state.text.isBlank() || country.text.isBlank()
                    ) {
                        message = "Por favor, preencha todos os campos!"
                    } else {
                        message = null
                        onSuccess()
                    }

                },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(containerColor = Purple40)
            ) {
                Text("Cadastrar", color = Color.White, fontSize = 18.sp)
            }

            message?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}