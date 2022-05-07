package com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem

import com.dimatsoft.codingchallenge.domain.model.HistoryItem
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import javax.inject.Inject

class SaveHistoryItemUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : SaveHistoryItemUseCase {

    override suspend operator fun invoke(historyItem: HistoryItem) = localRepository.saveHistoryItem(historyItem)
}