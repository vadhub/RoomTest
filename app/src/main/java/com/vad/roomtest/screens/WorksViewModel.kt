package com.vad.roomtest.screens

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vad.roomtest.room.dao.DaoWorks
import com.vad.roomtest.room.dao.Work
import com.vad.roomtest.room.database.AppDatabase
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WorksViewModel(application: Application) : ViewModel() {

    private val daoWork: DaoWorks
    val getWorks: LiveData<List<Work>>

    init {
        daoWork = AppDatabase.getDatabase(application).daoWorks()
        getWorks = daoWork.getAllWorks()
    }

    fun addWork(work: Work) = runBlocking {
        coroutineScope {
            launch {
                daoWork.addWork(work)
            }
        }
    }

    fun deleteWork(work: Work) = runBlocking {
        coroutineScope {
            launch {
                daoWork.deleteWork(work)
            }
        }
    }

    fun updateWork(work: Work) = runBlocking {
        coroutineScope {
            launch {
                daoWork.updateWork(work)
            }
        }
    }
}