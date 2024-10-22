package com.mohammed.mosa.eg.mybusiness.data.repoimpl

import com.mohammed.mosa.eg.mybusiness.data.local.dao.MovementDao
import com.mohammed.mosa.eg.mybusiness.data.module.Movement
import com.mohammed.mosa.eg.mybusiness.domain.repo.MovementRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MovementRepositoryImpl @Inject constructor(private val movementDao: MovementDao): MovementRepository {
    override suspend fun upsertMovement(movement: Movement) {
        movementDao.upsertMovement(movement)
    }

    override suspend fun upsertMovements(movements: List<Movement>) {
        movementDao.upsertMovements(movements)
    }

    override suspend fun deleteMovement(movement: Movement) {
        movementDao.deleteMovement(movement)
    }

    override suspend fun deleteMovements(movements: List<Movement>) {
        movementDao.deleteMovements(movements)
    }

    override fun getMovementsOrderedByDepartureDate(): Flow<List<Movement>> {
        return movementDao.getMovementsOrderedByDepartureDate()
    }

    override fun getMovementsOrderedByReturnDate(): Flow<List<Movement>> {
        return movementDao.getMovementsOrderedByReturnDate()
    }
}