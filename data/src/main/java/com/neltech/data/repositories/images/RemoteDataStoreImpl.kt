package com.neltech.data.repositories.images

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteDataStoreImpl
    @Inject constructor(private val remote: CommonDataSource,
                          private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) :CommonDataSource{
}