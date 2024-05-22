package presentation.input.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import presentation.input.state.InputUiEvents
import presentation.input.state.InputViewModel

@Composable
fun InputScreenRoute(
    inputViewModel: InputViewModel,
    calculate: () -> Unit,
) {

    val high = remember {
        mutableStateOf("")
    }
    val weight = remember {
        mutableStateOf("")
    }

    Scaffold {
        Column {
            TextField(
                value = high.value,
                onValueChange = { value ->
                    high.value = value
                    inputViewModel.onEvent(
                        InputUiEvents.UpdateHigh(value)
                    )
                },
                label = {
                    Text(
                        text = "altura em centimetros"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = weight.value,
                onValueChange = { value ->
                    weight.value = value
                    inputViewModel.onEvent(
                        InputUiEvents.UpdateWeight(value)
                    )
                },
                label = {
                    Text(
                        text = "peso em quilos"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    calculate()
                }
            ) {
                Text(
                    text = "calculate",
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}