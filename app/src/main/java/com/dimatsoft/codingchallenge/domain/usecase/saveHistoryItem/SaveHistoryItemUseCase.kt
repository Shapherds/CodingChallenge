package com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem

import com.dimatsoft.codingchallenge.domain.model.HistoryItem

interface SaveHistoryItemUseCase {

    suspend operator fun invoke(historyItem: HistoryItem )
}