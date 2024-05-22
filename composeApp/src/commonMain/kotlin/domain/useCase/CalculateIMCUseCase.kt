package domain.useCase

import kotlin.math.pow

class CalculateIMCUseCase {

    fun execute(
        high: Double,
        weight: Double,
    ): Double {
        return if (high < 1) {
            0.0
        } else {
            weight / (high / 100).pow(2)
        }
    }
}
