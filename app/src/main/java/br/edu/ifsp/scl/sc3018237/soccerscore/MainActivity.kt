package br.edu.ifsp.scl.sc3018237.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import br.edu.ifsp.scl.sc3018237.soccerscore.TelaConfiguracao

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MaterialTheme {

                TelaConfiguracao()
            }
        }
    }
}