package com.mobsky.home.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobsky.home.data.local.database.model.BookEntity
import com.mobsky.home.data.local.database.model.BooksEntity

@Dao
interface ABibliaDigitalDAO {

    @Query("SELECT * FROM book_table ORDER BY testament ASC")
    fun getBooks(): BooksEntity

    @Query("SELECT * FROM book_table ORDER BY RANDOM() LIMIT 1")
    fun getBookRandom(): BookEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(books: List<BookEntity>): List<Long>

}