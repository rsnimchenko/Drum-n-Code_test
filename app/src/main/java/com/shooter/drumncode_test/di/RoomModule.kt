package com.shooter.drumncode_test.di

import android.content.Context
import androidx.room.Room
import com.shooter.drumncode_test.data.local.EventDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideEventDatabase(
        @ApplicationContext context: Context
    ): EventDatabase = Room.databaseBuilder(
        context,
        EventDatabase::class.java,
        "event_database"
    ).build()

    @Provides
    fun provideEventDao(
        eventDatabase: EventDatabase
    ) = eventDatabase.eventDao()
}