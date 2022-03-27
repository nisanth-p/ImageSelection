package com.neltech.data.repositories.images

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class LocalDataStoreImpl @Inject constructor
(private val local: CommonDataSource,
                         private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) :CommonDataSource {
}