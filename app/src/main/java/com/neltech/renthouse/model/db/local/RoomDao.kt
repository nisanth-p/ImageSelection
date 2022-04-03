package com.neltech.renthouse.model.db.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.neltech.renthouse.model.db.tables.ImagesEntity


/**
* DAO provide methods that your app can use to query, update, insert, and delete data in the database.
*/

@Dao
interface SelectedImageDao{
    @Query("SELECT * FROM UserSelectedImage")
    fun getAll(): List<ImagesEntity>?

    @Insert
    fun insert(selectedImagesEntity: ImagesEntity)
}
