package com.neltech.renthouse.model.db.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neltech.renthouse.model.db.tables.ImagesEntity



/**
* Create room database instance. You can use it like this:
* val db = createRoomDb(context)
* val templateDao = db.templateDao()
* templateDao.getById(0)
*/
fun createRoomDb(applicationContext: Context): ImageDatabase {
    return Room.databaseBuilder(
        applicationContext,
        ImageDatabase::class.java, "database-name"
    ).build()
}

/**
* TemplateDatabase class holds the database. TemplateDatabase defines the database configuration
* and serves as the app's main access point to the persisted data.
*/
@Database(entities = [ImagesEntity::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {
    abstract fun selectImageDao(): SelectedImageDao
}
