package com.vad.roomtest.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoUsers {

    @Query("SELECT * FROM ${User.TABLE_NAME}")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}