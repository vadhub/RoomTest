package com.vad.roomtest.room.dao

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndWork(
    @Embedded
    val work: Work,

    @Relation(
        parentColumn = "work_id",
        entityColumn = "id_work"
    )

    val user: User

)