package com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems

import com.dimatsoft.codingchallenge.domain.model.HistoryItem

interface GetHistoryItemsUseCase {

    suspend operator fun invoke(): List<HistoryItem>
}