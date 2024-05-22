package presentation.di

import domain.useCase.CalculateIMCUseCase
import domain.useCase.FormatInputDoubleDataUseCase
import org.koin.dsl.module
import presentation.input.state.InputViewModel
import presentation.result.state.ResultViewModel

val presentationModules = module {

    single<InputViewModel> {
        InputViewModel(
            formatInputDoubleDataUseCase = FormatInputDoubleDataUseCase()
        )
    }

    single<ResultViewModel> {
        ResultViewModel(
            calculateIMCUseCase = CalculateIMCUseCase()
        )
    }
}
