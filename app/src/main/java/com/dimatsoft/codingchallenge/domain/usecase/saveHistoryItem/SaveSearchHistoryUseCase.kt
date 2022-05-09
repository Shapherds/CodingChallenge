package com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem

import com.dimatsoft.codingchallenge.domain.model.HistoryItem

interface SaveSearchHistoryUseCase {

    suspend operator fun invoke(text: String)
}