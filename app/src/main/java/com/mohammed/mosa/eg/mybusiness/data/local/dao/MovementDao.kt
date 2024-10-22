package com.mohammed.mosa.eg.mybusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohammed.mosa.eg.mybusiness.data.module.Movement
import kotlinx.coroutines.flow.Flow

@Dao
interface MovementDao {
    @Upsert
    suspend fun upsertMovement(movement: Movement)

    @Upsert
    suspend fun upsertMovements(movements: List<Movement>)

    @Delete
    suspend fun deleteMovement(movement: Movement)

    @Delete
    suspend fun deleteMovements(movements: List<Movement>)

    @Query("SELECT * FROM movements ORDER BY departureDate ASC")
    fun getMovementsOrderedByDepartureDate(): Flow<List<Movement>>

    @Query("SELECT * FROM movements ORDER BY returnDate ASC")
    fun getMovementsOrderedByReturnDate(): Flow<List<Movement>>


}