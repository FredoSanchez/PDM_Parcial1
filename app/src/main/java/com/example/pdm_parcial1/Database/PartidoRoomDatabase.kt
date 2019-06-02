package com.example.pdm_parcial1.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.dao.PartidoDAO
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Partido::class),version = 1)
public abstract class PartidoRoomDatabase : RoomDatabase() {
    abstract fun partidoDao() : PartidoDAO

    companion object {
        @Volatile
        private var INSTANCE: PartidoRoomDatabase? = null

        fun getDatabase(context: Context): PartidoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidoRoomDatabase::class.java,
                    "Book_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}