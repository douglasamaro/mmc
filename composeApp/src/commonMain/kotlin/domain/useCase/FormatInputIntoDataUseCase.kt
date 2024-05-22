package domain.useCase


class FormatInputDoubleDataUseCase {

    fun execute(value: String): Double {
        return if(value.isNotEmpty()) {
            value.toDoubleOrNull() ?: 0.0
        } else 0.0
    }
}