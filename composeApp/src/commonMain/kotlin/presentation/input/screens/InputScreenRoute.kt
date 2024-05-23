package presentation.input.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mmc.composeapp.generated.resources.Res
import mmc.composeapp.generated.resources.bottom_image
import mmc.composeapp.generated.resources.header_image
import org.jetbrains.compose.resources.painterResource
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

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF005B82))
            ) {
                Text(
                    text = "NutriAgora",
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(Res.drawable.header_image),
                modifier = Modifier.align(Alignment.TopStart),
                contentDescription = null
            )
            Image(
                painter = painterResource(Res.drawable.bottom_image),
                modifier = Modifier.align(Alignment.BottomEnd),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Calcule seu IMC",
                color = Color(0xFF005B82),
                fontSize = 27.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(
                modifier = Modifier.height(32.dp)
            )
            OutlinedTextField(
                value = high.value,
                onValueChange = { value ->
                    high.value = value
                    inputViewModel.onEvent(
                        InputUiEvents.UpdateHigh(value)
                    )
                },
                label = {
                    Text(
                        text = "altura em centimetros",
                        color = Color(0xFF005B82)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF005B82),
                    placeholderColor = Color(0xFF005B82),
                    textColor = Color(0xFF005B82),
                    cursorColor = Color(0xFF005B82),
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = weight.value,
                onValueChange = { value ->
                    weight.value = value
                    inputViewModel.onEvent(
                        InputUiEvents.UpdateWeight(value)
                    )
                },
                label = {
                    Text(
                        text = "peso em quilos",
                        color = Color(0xFF005B82)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF005B82),
                    placeholderColor = Color(0xFF005B82),
                    textColor = Color(0xFF005B82),
                    cursorColor = Color(0xFF005B82),
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF005B82)),
                onClick = {
                    calculate()
                }
            ) {
                Text(
                    text = "Calcular IMC",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 21.sp,
                    color = Color(0xFFFFFFFF),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}