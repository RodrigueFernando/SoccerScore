package br.edu.ifsp.scl.sc3018237.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    // Controla a navegação
    val navController = rememberNavController()

    // Aplica rotas
    NavHost(
        navController = navController,
        startDestination = "configuracao"
    ) {
        composable("configuracao") {
            TelaConfiguracao(navController)
        }

        // Rota da TelaResumo com parâmetros
        composable(
            route = "resumo/{timeA}/{timeB}/{golsA}/{golsB}",
            arguments = listOf( //cria um lista
                navArgument("timeA") { type = NavType.StringType },
                navArgument("timeB") { type = NavType.StringType },
                navArgument("golsA") { type = NavType.IntType },
                navArgument("golsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            // Recupera os parâmetros enviados pela navegação
            val timeA = backStackEntry.arguments?.getString("timeA") ?: ""
            val timeB = backStackEntry.arguments?.getString("timeB") ?: ""
            val golsA = backStackEntry.arguments?.getInt("golsA") ?: 0
            val golsB = backStackEntry.arguments?.getInt("golsB") ?: 0

            // Chama TelaResumo
            TelaResumo(
                navController = navController,
                timeA = timeA,
                timeB = timeB,
                golsA = golsA,
                golsB = golsB
            )
        }
        // Rota da TelaResultadoFinal
        composable(
            route = "resultado/{timeA}/{timeB}/{golsA}/{golsB}",
            arguments = listOf(
                navArgument("timeA") { type = NavType.StringType },
                navArgument("timeB") { type = NavType.StringType },
                navArgument("golsA") { type = NavType.IntType },
                navArgument("golsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val timeA = backStackEntry.arguments?.getString("timeA") ?: ""
            val timeB = backStackEntry.arguments?.getString("timeB") ?: ""
            val golsA = backStackEntry.arguments?.getInt("golsA") ?: 0
            val golsB = backStackEntry.arguments?.getInt("golsB") ?: 0

            TelaResultadoFinal(
                navController = navController,
                timeA = timeA,
                timeB = timeB,
                golsA = golsA,
                golsB = golsB
            )
        }
    }
}