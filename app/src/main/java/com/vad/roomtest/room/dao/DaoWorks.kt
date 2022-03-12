package com.vad.roomtest.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoWorks {

    @Query("SELECT * FROM ${Work.TABLE_NAME}")
    suspend fun getAllWorks(): LiveData<List<Work>>

    @Insert
    suspend fun addWork(work: Work)

    @Update
    suspend fun updateWork(work: Work)

    @Delete
    suspend fun deleteWork(work: Work)

}