package com.dimatsoft.codingchallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dimatsoft.codingchallenge.data.model.HistoryItemLocal

@Database(entities = [HistoryItemLocal::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getVideoDao(): HistoryItemDao
}