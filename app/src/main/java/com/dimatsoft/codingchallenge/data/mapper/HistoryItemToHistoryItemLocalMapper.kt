package com.dimatsoft.codingchallenge.data.mapper

import com.dimatsoft.codingchallenge.data.model.HistoryItemLocal
import com.dimatsoft.codingchallenge.domain.model.HistoryItem
import javax.inject.Inject

class HistoryItemToHistoryItemLocalMapper @Inject constructor() :
        (HistoryItem) -> HistoryItemLocal {

    override fun invoke(item: HistoryItem): HistoryItemLocal {
        return HistoryItemLocal(time = item.time, text = item.text)
    }
}