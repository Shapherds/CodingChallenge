package com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems

import com.dimatsoft.codingchallenge.domain.model.HistoryItem
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import javax.inject.Inject

class GetHistoryItemsUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : GetHistoryItemsUseCase {

    override suspend fun invoke(): List<HistoryItem> = localRepository.getHistory()
}