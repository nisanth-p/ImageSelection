package com.neltech.domain.usecases

import com.neltech.domain.common.NetworkHelper
import com.neltech.domain.repositories.ImageRepository
import javax.inject.Inject

class ImageUploadUseCase @Inject constructor(private val imageRepository: ImageRepository,
                                             private val networkHelper: NetworkHelper){}