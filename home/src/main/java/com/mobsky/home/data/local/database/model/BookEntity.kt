package com.mobsky.home.data.local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

typealias BooksEntity = List<BookEntity>

@Entity(tableName = "book_table")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "chapters")
    val chapters: Int,
    @ColumnInfo(name = "group")
    val group: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "testament")
    val testament: String,
    @ColumnInfo(name = "abrev_en")
    val abrevEn: String,
    @ColumnInfo(name = "abrev_pt")
    val abrevPt: String
)