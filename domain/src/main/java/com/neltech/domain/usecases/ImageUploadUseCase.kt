package com.neltech.domain.usecases

import com.neltech.renthouse.model.utill.NetworkHelper
import com.neltech.renthouse.model.db.repository.ImageRepository
import javax.inject.Inject

class ImageUploadUseCase @Inject constructor(private val imageRepository: com.neltech.renthouse.model.db.repository.ImageRepository,
                                             private val networkHelper: com.neltech.renthouse.model.utill.NetworkHelper
){}