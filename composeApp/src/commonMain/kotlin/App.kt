import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import presentation.di.presentationModules
import presentation.navigation.RootNavGraph

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(presentationModules)
        }
    ) {
        MaterialTheme {
            RootNavGraph()
        }
    }
}
