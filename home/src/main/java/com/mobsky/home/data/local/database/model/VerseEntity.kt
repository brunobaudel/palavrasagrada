package com.mobsky.home.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verse_table")
data class VerseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "book_id")
    val bookId: String,
    @ColumnInfo(name = "chapter_number")
    val chapterNumber: Int,
    @ColumnInfo(name = "number")
    val number: Int,
    @ColumnInfo(name = "text")
    val text: String
)