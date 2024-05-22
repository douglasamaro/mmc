package domain.useCase

class FormatInputIntoDataUseCase {

    fun execute(value: String) : Double {
        return value.toDouble()
    }
}