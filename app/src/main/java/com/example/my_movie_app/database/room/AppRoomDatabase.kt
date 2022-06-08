package com.example.my_movie_app.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.my_movie_app.data.NoteData


@Database(version = 1, entities = [NoteData::class], exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getAppRoomDao(): AppRoomDao

    companion object{
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            var tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                return instance
            }
        }




    }





}