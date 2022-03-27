package com.neltech.renthouse.di


import android.content.Context
import android.content.ContextWrapper
import com.google.android.material.internal.ContextUtils
import com.neltech.data.repositories.images.CommonDataSource
import com.neltech.data.repositories.images.ImageRepositoryImpl
import com.neltech.data.repositories.images.RemoteDataStoreImpl
import com.neltech.domain.common.NetworkHelper
import com.neltech.domain.usecases.ImageUploadUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteDataSource
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalDataSource
    @Singleton
    @Provides
    fun provideImageRepositoryImpl(
        @AppModule.LocalDataSource local: CommonDataSource,
        @AppModule.RemoteDataSource remote: CommonDataSource,
        ioDispatcher: CoroutineDispatcher
    ): ImageRepositoryImpl {
        return ImageRepositoryImpl(local, remote, ioDispatcher)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton // Provide always the same instance
    @Provides // Run this code when providing an instance of CoroutineScope
    fun providesCoroutineScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @LocalDataSource
    @Singleton
    @Provides
    fun provideLocalDataStoreImpl(local: CommonDataSource,
                                  ioDispatcher: CoroutineDispatcher): CommonDataSource = RemoteDataStoreImpl(local, ioDispatcher)

    @RemoteDataSource
    @Singleton
    @Provides
    fun provideRemoteDataStoreImpl(remote: CommonDataSource,
                                   ioDispatcher: CoroutineDispatcher): CommonDataSource = RemoteDataStoreImpl(remote, ioDispatcher)

    @Singleton
    @Provides
    fun provideImageUploadUseImpl(repositoryImpl: ImageRepositoryImpl,networkHelper: NetworkHelper):ImageUploadUseCase =
        ImageUploadUseCase(repositoryImpl,networkHelper)
}
