package com.dimatsoft.codingchallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historyItem")
data class HistoryItemLocal(
    @PrimaryKey @ColumnInfo(name = "time_search") val time: Long,
    @ColumnInfo(name = "search_text") val text: String,
)