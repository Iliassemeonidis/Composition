package com.example.composition.domain.usecases

import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository

class GenerateQuestionsUseCase(private val gameRepository: GameRepository) {

    operator fun invoke(maxSizeValue: Int): Question {
        return gameRepository.generateQuestion(maxSizeValue, COUNT_OF_OPTIONS)
    }

    companion object {
        const val COUNT_OF_OPTIONS = 6
    }
}