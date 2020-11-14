package com.pesan.note.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pesan.note.data.TodoDao
import com.pesan.note.model.TodoData
import com.pesan.note.data.TodoDatabase
import com.pesan.note.respository.TodoRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val todoDao: TodoDao = TodoDatabase.getDatabase(application).todoDao()
    private val respository: TodoRespository

    val getAllData: LiveData<List<TodoData>>
    val sortByHighPriority: LiveData<List<TodoData>>
    val sortByLowPriority: LiveData<List<TodoData>>

    init {
       respository = TodoRespository(todoDao)
        getAllData = respository.getAllData
        sortByHighPriority = respository.sortByHighPriority
        sortByLowPriority = respository.sortByLowPriority
    }

    fun insertData(todoData: TodoData){
        viewModelScope.launch(Dispatchers.IO){
            respository.insertData(todoData)
        }
    }

    fun updateData(todoData: TodoData){
        viewModelScope.launch(Dispatchers.IO){
            respository.updateData(todoData)
        }
    }

    fun deleteData(todoData: TodoData){
        viewModelScope.launch(Dispatchers.IO){
            respository.deleteData(todoData)
        }
    }

    fun deleteAllData(todoData: TodoData){
        viewModelScope.launch(Dispatchers.IO){
            respository. deleteAll()
        }
    }

   fun searchRespository(searchQuery: String): LiveData<List<TodoData>>{
        return respository.searchDatabase(searchQuery )
    }

}