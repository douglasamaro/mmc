package presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.koinInject
import presentation.input.screens.InputScreenRoute
import presentation.input.state.InputViewModel
import presentation.result.screens.ResultScreenRoute
import presentation.result.state.ResultUiEvents
import presentation.result.state.ResultViewModel
import presentation.start.screens.SplashScreen


@Composable
fun RootNavGraph(
    inputViewModel: InputViewModel = koinInject(),
    resultViewModel: ResultViewModel = koinInject()
) {
    Scaffold { innerPadding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screens.Splash.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screens.Splash.name) {
                SplashScreen(
                    navController = navController
                )
            }
            composable(route = Screens.Input.name) {
                InputScreenRoute(
                    inputViewModel = inputViewModel,
                    calculate = {
                        resultViewModel.onEvent(
                            ResultUiEvents.SetUserDataForResult(
                                high = inputViewModel.high.value,
                                weight = inputViewModel.weight.value
                            )
                        )
                        navController.navigate(Screens.Result.name)
                    }
                )
            }
            composable(route = Screens.Result.name) {
                ResultScreenRoute(
                    navController = navController,
                    resultViewModel = resultViewModel,
                )
            }
        }
    }
}
