package com.shooter.drumncode_test.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shooter.drumncode_test.domain.model_db.EventModelDB
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM event WHERE sportId=:sportId")
    fun getEventsSpecifySport(sportId: String): Flow<List<EventModelDB>>

    @Insert
    suspend fun insert(eventModelDB: EventModelDB)

    @Delete
    suspend fun delete(eventModelDB: EventModelDB)
}