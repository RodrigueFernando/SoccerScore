package br.edu.ifsp.scl.sc3018237.soccerscore


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TelaResumo(

    // Dados recebidos da Tela 1
    navController: NavController,
    timeA: String,
    timeB: String,
    golsA: Int,
    golsB: Int
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        // Centraliza os componentes na tela
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "Resumo da Partida")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "$timeA x $timeB")


        Text(text = "$golsA x $golsB")

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            navController.navigate(
                "resultado/$timeA/$timeB/$golsA/$golsB"
            )
        }) {

            Text("Confirmar Resultado")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botão para voltar e editar os dados
        Button(onClick = {
            navController.popBackStack()
        }) {

            Text("Editar")
        }
    }
}