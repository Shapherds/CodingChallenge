package com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem

import com.dimatsoft.codingchallenge.domain.model.HistoryItem
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import javax.inject.Inject

class SaveSearchHistoryUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : SaveSearchHistoryUseCase {

    override suspend operator fun invoke(text: String) {
        val timeNow = System.currentTimeMillis()
        localRepository.saveHistoryItem(HistoryItem(timeNow, text))
    }
}