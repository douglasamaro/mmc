package presentation.result.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import presentation.result.state.ResultViewModel

@Composable
fun ResultScreenRoute(
    resultViewModel: ResultViewModel,
    navController: NavController
) {
    Scaffold {

        val imc = resultViewModel.imc.collectAsState().value

        Column {
            Text(
                text = "$imc"
            )
        }
    }
}