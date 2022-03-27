package com.neltech.data.repositories.images

import com.neltech.domain.repositories.ImageRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(private val local: CommonDataSource,
                                              private val remote: CommonDataSource,
                                              private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO):ImageRepository {
}