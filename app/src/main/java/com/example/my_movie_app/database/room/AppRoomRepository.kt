package com.example.my_movie_app.database.room

import androidx.lifecycle.LiveData
import com.example.my_movie_app.data.NoteData

class AppRoomRepository(private val noteDao: AppRoomDao) {


    fun getAllNites(): LiveData<List<NoteData>> = noteDao.getAllNotes()

    suspend fun insertNotes(noteData: NoteData){
        noteDao.insert(noteData)
    }

    suspend fun deleteNotes(noteData: NoteData){
        noteDao.delete(noteData)
    }

    suspend fun updateNotes(noteData: NoteData){
        noteDao.updateTodo(noteData)
    }

}