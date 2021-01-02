package com.androar.mvvmtodo.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.androar.mvvmtodo.data.TaskDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class TasksViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao
) : ViewModel() {

    val searchQuery = MutableStateFlow<String>("")

    private val taskFlow = searchQuery.flatMapLatest {
        taskDao.getTasks(it) //Flat map latest is like concat map latest value it takes. In fragment when changing value, we'll switch this.
    }

    val tasks = taskFlow.asLiveData()


}