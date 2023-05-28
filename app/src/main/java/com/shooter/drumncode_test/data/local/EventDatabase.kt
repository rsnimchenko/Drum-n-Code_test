package com.shooter.drumncode_test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shooter.drumncode_test.domain.model_db.EventModelDB

@Database(
    entities = [EventModelDB::class],
    version = 1
)
abstract class EventDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao
}