package domain.useCase

import kotlin.math.pow

class CalculateIMCUseCase {

    fun execute(
        high: Double,
        weight: Double,
    ) : Double {
        return weight / high.pow(2)
    }
}