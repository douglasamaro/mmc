package presentation.result.state

sealed interface ResultUiEvents {

    data class SetUserDataForResult(
        val high: Double,
        val weight: Double
    ) : ResultUiEvents

}
