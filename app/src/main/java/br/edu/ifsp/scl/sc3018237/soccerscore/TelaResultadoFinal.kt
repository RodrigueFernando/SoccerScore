package br.edu.ifsp.scl.sc3018237.soccerscore

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TelaResultadoFinal(
    navController: NavController,
    timeA: String,
    timeB: String,
    golsA: Int,
    golsB: Int
) {
    // Define o resultado da partida
    val resultado = when {
        golsA > golsB -> "$timeA venceu!"
        golsB > golsA -> "$timeB venceu!"
        else -> "Empate emocionante!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Resultado Final",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "$timeA $golsA x $golsB $timeB")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = resultado)

        Spacer(modifier = Modifier.height(16.dp))

        // Volta para a Tela 1 limpando o histórico
        Button(
            onClick = {
                navController.navigate("configuracao") {
                    popUpTo("configuracao") {
                        inclusive = true
                    }
                }
            }
        ) {
            Text("Novo Jogo")
        }
    }
}