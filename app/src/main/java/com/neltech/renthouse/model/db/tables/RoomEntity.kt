package com.neltech.renthouse.model.db.tables

import androidx.room.*

/**
* Entities represent tables in your app's database.
*/

@Entity(tableName = "UserSelectedImage")
data class ImagesEntity( @PrimaryKey(autoGenerate = true)
                           @ColumnInfo(name = "id")
                           val  id: Long? ,
                           @ColumnInfo(name = "images")
                           val  images: String )