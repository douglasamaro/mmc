package presentation.input.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.useCase.FormatInputDoubleDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InputViewModel(
    private val formatInputDoubleDataUseCase: FormatInputDoubleDataUseCase
) : ViewModel() {

    private val _high = MutableStateFlow(0.0)
    val high: StateFlow<Double> = _high

    private val _weight = MutableStateFlow(0.0)
    val weight: StateFlow<Double> = _weight

    fun onEvent(event: InputUiEvents) {
        viewModelScope.launch {
            when (event) {
                is InputUiEvents.UpdateHigh -> {
                    val high = formatInputDoubleDataUseCase.execute(event.high)
                    _high.value = high
                }
                is InputUiEvents.UpdateWeight -> {
                    val weight = formatInputDoubleDataUseCase.execute(event.weight)
                    _weight.value = weight
                }
            }
        }
    }
}
