package com.neltech.renthouse.di


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.neltech.renthouse.model.db.api.ApiService
import com.neltech.renthouse.model.db.local.ImageDatabase
import com.neltech.renthouse.model.db.local.LocalDataStoreImpl
import com.neltech.renthouse.model.db.local.SelectedImageDao
import com.neltech.renthouse.model.db.source.CommonDataSource
import com.neltech.renthouse.model.db.repository.ImageRepositoryImpl
import com.neltech.renthouse.model.db.remote.RemoteDataStoreImpl
import com.neltech.renthouse.model.utill.IPref
import com.neltech.renthouse.model.utill.PrefImpl
import com.neltech.renthouse.model.utill.UrlConstants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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
    fun provideLocalDataStoreImpl( database: ImageDatabase,
                                  ioDispatcher: CoroutineDispatcher): CommonDataSource = LocalDataStoreImpl(database, ioDispatcher)

    @RemoteDataSource
    @Singleton
    @Provides
    fun provideRemoteDataStoreImpl(remote: ApiService,
                                   ioDispatcher: CoroutineDispatcher): CommonDataSource = RemoteDataStoreImpl(remote, ioDispatcher)

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.callTimeout(40, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
        okHttpClient.readTimeout(40, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(40, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.build()
        return okHttpClient.build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        //https://rickandmortyapi.com/api/
        .baseUrl(UrlConstants.BASE_APPSCRIPT_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideSelectedImage(
        database: ImageDatabase,
        ioDispatcher: CoroutineDispatcher
    ): SelectedImageDao = database.selectImageDao()
}
@Module
@InstallIn(SingletonComponent::class)

abstract class ResourceWrapperModule {
    @Singleton
    @Binds
    abstract fun bindPrefImpl(prefImpl: PrefImpl): IPref
}