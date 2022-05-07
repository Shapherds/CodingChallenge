package com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems

interface GetSearchHistoryUseCase {

    suspend operator fun invoke(): List<String>
}