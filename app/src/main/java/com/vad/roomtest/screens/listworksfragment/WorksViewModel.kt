package com.vad.roomtest.screens.listworksfragment

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vad.roomtest.room.dao.DaoWorks
import com.vad.roomtest.room.dao.Work
import com.vad.roomtest.room.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorksViewModel(application: Application) : ViewModel() {

    private val daoWork: DaoWorks
    val getWorks: LiveData<List<Work>>

    init {
        daoWork = AppDatabase.getDatabase(application).daoWorks()
        getWorks = daoWork.getAllWorks()
    }

    fun addWork(work: Work) {
        viewModelScope.launch {
            launch {
                daoWork.addWork(work)
            }
        }

    }

    fun deleteWork(work: Work) {
        viewModelScope.launch {
            launch {
                daoWork.deleteWork(work)
            }
        }
    }

    fun updateWork(work: Work) {
        viewModelScope.launch {
            launch {
                daoWork.updateWork(work)
            }
        }
    }
}