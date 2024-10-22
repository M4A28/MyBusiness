package com.mohammed.mosa.eg.mybusiness.domain.repo

import com.mohammed.mosa.eg.mybusiness.data.module.Movement
import kotlinx.coroutines.flow.Flow

interface MovementRepository {

    suspend fun upsertMovement(movement: Movement)

    suspend fun upsertMovements(movements: List<Movement>)

    suspend fun deleteMovement(movement: Movement)

    suspend fun deleteMovements(movements: List<Movement>)

    fun getMovementsOrderedByDepartureDate(): Flow<List<Movement>>

    fun getMovementsOrderedByReturnDate(): Flow<List<Movement>>

}