package presentation.start.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.navigation.Screens

@Composable
fun SplashScreen(
    navController: NavController
) {
    val scope = rememberCoroutineScope()

    scope.launch {
        delay(2000)
        navController.navigate(Screens.Input.name)
    }

    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "splash"
            )
        }
    }
}