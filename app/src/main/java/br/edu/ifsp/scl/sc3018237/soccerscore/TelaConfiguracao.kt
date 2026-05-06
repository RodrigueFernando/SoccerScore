package br.edu.ifsp.scl.sc3018237.soccerscore

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TelaConfiguracao(
    navController: NavController
) {

    // Estados da tela salvos mesmo após rotação
    var timeA by rememberSaveable { mutableStateOf("") }
    var timeB by rememberSaveable { mutableStateOf("") }
    var golsA by rememberSaveable { mutableStateOf("") }
    var golsB by rememberSaveable { mutableStateOf("") }

    // Mensagem de erro da validação
    var mensagemErro by rememberSaveable {
        mutableStateOf("")
    }
    // Controla a exibição da TelaResumo
    var mostrarResumo by rememberSaveable {
        mutableStateOf(false)
    }

    // Se os dados forem válidos, mostra a TelaResumo
    if (mostrarResumo) {

        TelaResumo(
            navController = navController,
            timeA = timeA,
            timeB = timeB,
            golsA = golsA.toInt(),
            golsB = golsB.toInt()
        )

    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Configuração da Partida", style = MaterialTheme.typography.titleLarge)


            Spacer(modifier = Modifier.height(16.dp))

            // Campo para nome do Time A
            OutlinedTextField(
                value = timeA,
                onValueChange = {
                    timeA = it
                },
                label = {
                    Text("Nome do Time A")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo para nome do Time B
            OutlinedTextField(
                value = timeB,
                onValueChange = {
                    timeB = it
                },
                label = {
                    Text("Nome do Time B")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo para gols do Time A
            OutlinedTextField(
                value = golsA,
                onValueChange = {
                    golsA = it
                },
                label = {
                    Text("Gols do Time A")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo para gols do Time B
            OutlinedTextField(
                value = golsB,
                onValueChange = {
                    golsB = it
                },
                label = {
                    Text("Gols do Time B")
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                    // String para Int
                    val golsAInt = golsA.toIntOrNull()
                    val golsBInt = golsB.toIntOrNull()

                    // Verifica campos vazios
                    if (
                        timeA.isBlank() ||
                        timeB.isBlank() ||
                        golsA.isBlank() ||
                        golsB.isBlank()
                    ) {

                        mensagemErro =
                            "Preencha todos os campos."

                    }
                    // Verifica números inválidos
                    else if (
                        golsAInt == null ||
                        golsBInt == null ||
                        golsAInt < 0 ||
                        golsBInt < 0
                    ) {

                        mensagemErro =
                            "Os gols devem ser números válidos."

                    } else {

                        // Limpa erro
                        mensagemErro = ""
                        // Navega para TelaResumo
                        navController.navigate(
                            "resumo/$timeA/$timeB/$golsAInt/$golsBInt"
                        )
                    }
                }
            ) {

                Text("Ver Resultado")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Exibe mensagem de erro
            Text(text = mensagemErro)
        }
    }
}