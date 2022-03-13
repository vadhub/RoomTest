package com.vad.roomtest.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vad.roomtest.App
import com.vad.roomtest.room.dao.Work
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WorksViewModel : ViewModel() {
    private val daoWork = App.instance.daoWorks
    val getWorks: LiveData<List<Work>> = daoWork.getAllWorks()

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