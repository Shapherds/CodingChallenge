package com.dimatsoft.codingchallenge.data.mapper

import com.dimatsoft.codingchallenge.data.model.HistoryItemLocal
import com.dimatsoft.codingchallenge.domain.model.HistoryItem
import javax.inject.Inject

class HistoryItemLocalToHistoryItemMapper @Inject constructor() :
        (HistoryItemLocal) -> HistoryItem {

    override fun invoke(item: HistoryItemLocal): HistoryItem {
        return HistoryItem(time = item.time, text = item.text)
    }
}