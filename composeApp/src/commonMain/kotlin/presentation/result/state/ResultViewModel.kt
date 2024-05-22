package presentation.result.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.useCase.CalculateIMCUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResultViewModel(
    private val calculateIMCUseCase: CalculateIMCUseCase
) : ViewModel() {

    private val _imc = MutableStateFlow(0.0)
    val imc: StateFlow<Double> = _imc

    fun onEvent(event: ResultUiEvents) {
        viewModelScope.launch {
            when (event) {
                is ResultUiEvents.SetUserDataForResult -> {
                    val imc = calculateIMCUseCase.execute(
                        high = event.high,
                        weight = event.weight
                    )
                    _imc.value = imc
                }
            }
        }
    }
}
