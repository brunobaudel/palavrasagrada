package com.mobsky.palavrasagrada.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobsky.home.data.local.database.ABibliaDigitalDAO
import com.mobsky.home.data.local.database.model.BookEntity

@Database(
    entities = [BookEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PalavraSagradaDatabase : RoomDatabase() {

    abstract fun aBibliaDigitalDAO(): ABibliaDigitalDAO

    companion object {
        @Volatile
        private var instance: PalavraSagradaDatabase? = null

        fun getDatabase(context: Context): PalavraSagradaDatabase =
            instance ?: synchronized(this) {
                buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context): PalavraSagradaDatabase {
            return Room
                .databaseBuilder(
                    appContext,
                    PalavraSagradaDatabase::class.java,
                    "PalavraSagradaDB"
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}