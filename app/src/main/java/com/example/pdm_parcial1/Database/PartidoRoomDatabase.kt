package com.example.pdm_parcial1.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pdm_parcial1.Entities.Partido
import com.example.pdm_parcial1.dao.PartidoDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Partido::class),version = 1, exportSchema = false)
abstract class PartidoRoomDatabase : RoomDatabase() {
    abstract fun partidoDao() : PartidoDAO

    companion object {
        @Volatile
        private var INSTANCE: PartidoRoomDatabase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ):PartidoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context,PartidoRoomDatabase::class.java,"PartidoDB")
                    .addCallback(PartidoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class PartidoDatabaseCallback(
                private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database -> scope.launch(Dispatchers.IO){
                    populateDatabase(database.partidoDao())
                } }
            }
        }

        suspend fun populateDatabase(partidoDao: PartidoDAO) {
            partidoDao.deleteAllPartidos()

            var partido = Partido("UCA","ESEN", 23,20)
            partidoDao.insertPartido(partido)
            partido = Partido("Uasafs","fsav", 224,250)
            partidoDao.insertPartido(partido)
        }

    }


}