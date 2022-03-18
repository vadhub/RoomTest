package com.vad.roomtest.screens.listusersfragment

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vad.roomtest.room.dao.DaoUsers
import com.vad.roomtest.room.dao.User
import com.vad.roomtest.room.dao.UserAndWork
import com.vad.roomtest.room.database.AppDatabase
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): ViewModel() {
    private val daoUser: DaoUsers
    val getUsers: LiveData<List<UserAndWork>>

    init {
        daoUser = AppDatabase.getDatabase(application).daoUsers()
        getUsers = daoUser.getAllUsers()
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            launch {
                daoUser.addUser(user)
            }
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            launch {
                daoUser.updateUser(user)
            }
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            daoUser.deleteUser(user)
        }
    }
}