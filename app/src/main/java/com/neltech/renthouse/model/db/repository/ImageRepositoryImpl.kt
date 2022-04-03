package com.neltech.renthouse.model.db.repository

import com.neltech.renthouse.model.db.source.CommonDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(private val local: CommonDataSource,
                                              private val remote: CommonDataSource,
                                              private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO):ImageRepository {

}