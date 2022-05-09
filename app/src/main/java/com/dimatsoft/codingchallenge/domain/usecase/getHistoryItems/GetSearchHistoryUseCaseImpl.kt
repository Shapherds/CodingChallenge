package com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems

import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import javax.inject.Inject

class GetSearchHistoryUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : GetSearchHistoryUseCase {

    override suspend fun invoke(): List<String> = localRepository.getHistory()
        .map { it.text }
}