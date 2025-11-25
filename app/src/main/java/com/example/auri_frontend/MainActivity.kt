package com.example.auri_frontend

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auri_frontend.components.UserButtonData
import com.example.auri_frontend.screens.AddButton
import com.example.auri_frontend.screens.HomeScreen
import com.example.auri_frontend.screens.LoginScreen
import com.example.auri_frontend.screens.RegisterScreen
import com.example.auri_frontend.screens.SettingsScreen
import com.example.auri_frontend.screens.SpeakScreen
import com.example.auri_frontend.screens.WelcomeScreen
import com.example.auri_frontend.ui.theme.AurifrontendTheme
import java.util.Locale

class MainActivity : ComponentActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private var isTtsReady = false

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        tts = TextToSpeech(this, this)

        setContent {
            val userButtons = remember { mutableStateListOf<UserButtonData>() }

            AurifrontendTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "welcome",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            composable("welcome") {
                                WelcomeScreen(
                                    onLoginClick = { navController.navigate("login") },
                                    onRegisterClick = { navController.navigate("register") },
                                    onGuestClick = {
                                        navController.navigate("home") {
                                            popUpTo("welcome") { inclusive = true }
                                        }
                                    }
                                )
                            }

                            composable("login") {
                                LoginScreen(
                                    onLoginSuccess = {
                                        navController.navigate("home") {
                                            popUpTo("login") { inclusive = true }
                                        }
                                    },
                                    onBackClick = { navController.popBackStack() }
                                )
                            }

                            composable("register") {
                                RegisterScreen(
                                    onSuccess = {
                                        navController.navigate("home") {
                                            popUpTo("register") { inclusive = true }
                                        }
                                    },
                                    onBackClick = { navController.popBackStack() }
                                )
                            }

                            composable("home") {
                                HomeScreen(
                                    onSpeakClick = { navController.navigate("speak") },
                                    onSettingsClick = { navController.navigate("settings") }
                                )
                            }

                            composable("speak") {
                                SpeakScreen(
                                    userButtons = userButtons,
                                    onBackClick = { navController.popBackStack() },
                                    onSpeak = { text -> speakText(text) },
                                    onAddClick = { navController.navigate("addSpeak") }
                                )
                            }


                            composable("settings") {
                                SettingsScreen(onBackClick = { navController.popBackStack() })
                            }

                            composable("addSpeak") {
                                AddButton(
                                    onSaveClick = { text, image ->
                                        userButtons.add(UserButtonData(text, image))
                                        navController.popBackStack()
                                    },
                                    onBackClick = { navController.popBackStack() }
                                )
                            }

                        }
                    }
                }
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val locale = Locale.Builder().setLanguage("pt").setRegion("BR").build()
            val result = tts.setLanguage(locale)
            isTtsReady =
                result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED
        }
    }

    private fun speakText(text: String) {
        if (isTtsReady) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onDestroy() {
        tts.stop()
        tts.shutdown()
        super.onDestroy()
    }
}
