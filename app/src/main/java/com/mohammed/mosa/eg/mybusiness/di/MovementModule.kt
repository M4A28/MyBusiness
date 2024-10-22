package com.mohammed.mosa.eg.mybusiness.di

import com.mohammed.mosa.eg.mybusiness.data.local.dao.MovementDao
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.data.repoimpl.MovementRepositoryImpl
import com.mohammed.mosa.eg.mybusiness.domain.repo.MovementRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovementModule {
    @Provides
    @Singleton
    fun provideMovementDao(db: AppDatabase): MovementDao {
        return db.movementDao
    }


    @Provides
    @Singleton
    fun provideMovementRepository(movementDao: MovementDao): MovementRepository {
        return MovementRepositoryImpl(movementDao)
    }

}