package com.example.simpleconverter.di

import com.example.simpleconverter.repo.TemperatureRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module @InstallIn(SingletonComponent::class)
object AppModule {
    @Provides @Singleton
    fun provideRepo() = TemperatureRepository()
}