package com.dimatsoft.codingchallenge.di.module

import android.content.Context
import androidx.room.Room
import com.dimatsoft.codingchallenge.data.database.HistoryItemDao
import com.dimatsoft.codingchallenge.data.database.LocalDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideVideoDao(localDatabase: LocalDatabase): HistoryItemDao {
        return localDatabase.getVideoDao()
    }

    @Provides
    fun provideDatabase(context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            LocalDatabase::class.java,
            "database")
            .build()
    }
}