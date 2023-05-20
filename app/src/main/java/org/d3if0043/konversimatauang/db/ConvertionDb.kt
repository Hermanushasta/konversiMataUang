package org.d3if0043.konversimatauang.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConvertionEntity::class], version = 1, exportSchema = false)
abstract class ConvertionDb : RoomDatabase() {
    abstract val dao: ConvertionDao

    companion object {
        @Volatile
        private var INSTANCE: ConvertionDb? = null

        fun getInstance(context: Context) : ConvertionDb {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConvertionDb::class.java,
                        "convertion.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}