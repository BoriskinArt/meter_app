package com.example.my_movie_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_tables")
data class NoteData(
    @PrimaryKey(autoGenerate = true)val id: Int,
    @ColumnInfo(name = "electricity") val electricity: String,
    @ColumnInfo(name = "XBC") val XBC: String,
    @ColumnInfo(name = "GBC") val GBC: String,
    @ColumnInfo(name = "GAS") val GAS: String
): Serializable
