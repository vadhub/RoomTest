package com.vad.roomtest.room.dao

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndWork(
    @Embedded
    val user: User,

    @Relation(
        parentColumn = "id_work",
        entityColumn = "work_id"
    )

    val work: Work
)