package com.vad.roomtest.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vad.roomtest.room.dao.Work.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Work(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "work_id")
    val workId: Int,

    @ColumnInfo(name = "name_work")
    val nameWork: String,

    @ColumnInfo(name = "price")
    val price: Double

) {
    companion object {
        const val TABLE_NAME = "work_table"
    }

}
