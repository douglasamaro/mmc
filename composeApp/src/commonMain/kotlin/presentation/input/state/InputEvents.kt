package presentation.input.state

sealed interface InputUiEvents {

    data class UpdateHigh(
        val high: String
    ) : InputUiEvents

    data class UpdateWeight(
        val weight: String
    ) : InputUiEvents
}
