package com.example.my_movie_app.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.my_movie_app.data.NoteData
import com.example.my_movie_app.database.room.AppRoomDatabase
import com.example.my_movie_app.database.room.AppRoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application): AndroidViewModel(application)  {
    private val repository: AppRoomRepository
    val allTodo: LiveData<List<NoteData>>

    init {
        val noteDB = AppRoomDatabase.getDatabase(application).getAppRoomDao()
        repository = AppRoomRepository(noteDB)
        allTodo = repository.getAllNites()
    }

    fun addNode(noteDate: NoteData){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertNotes(noteDate)
        }
    }





}