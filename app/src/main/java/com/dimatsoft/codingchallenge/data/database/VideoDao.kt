package com.dimatsoft.codingchallenge.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dimatsoft.codingchallenge.data.model.HistoryItemLocal

@Dao
interface HistoryItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setItem(historyItemLocal: HistoryItemLocal)

    @Query("SELECT * FROM historyItem ORDER by time_search DESC")
    suspend fun getItems(): List<HistoryItemLocal>
}