package com.mohammed.mosa.eg.mybusiness.di


import androidx.room.Room
import com.mohammed.mosa.eg.mybusiness.data.local.converters.LocalDateTimeConverter
import com.mohammed.mosa.eg.mybusiness.data.local.db.AppDatabase
import com.mohammed.mosa.eg.mybusiness.main.MyBusinessApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: MyBusinessApplication): AppDatabase {

        return Room.databaseBuilder(
            context = app,
            klass = AppDatabase::class.java,
            name = "app_database")
            .addTypeConverter(LocalDateTimeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

}